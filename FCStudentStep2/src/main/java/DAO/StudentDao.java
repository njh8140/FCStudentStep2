package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Student;

public class StudentDao {
	DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	public int update(Student student) throws Exception{
		Connection con = null;
		PreparedStatement pst = null;
		String query = null;
		
		try {
			con = ds.getConnection();
			query = "update student set name = ?, email=?, pwd=?, mod_date=now() where no=?";
			pst = con.prepareStatement(query);
			pst.setString(1, student.getName());
			pst.setString(2, student.getEmail());
			pst.setString(3, student.getPwd());
			pst.setInt(4, student.getNo());
			
			return pst.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally{
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){} //썼으면 반납해야 한다
		}	
	}

	public Student selectOne(int no) throws Exception{
		System.out.println("DAO selectOne();");
		PreparedStatement pst = null;
		String query = null;
		ResultSet rs = null;
		Connection con = null;
		try{
			con = ds.getConnection();
			query = "select * from student where no = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, no);
			
			rs = pst.executeQuery();
			
			if(!rs.next()) {
				return null;
			} else {
				Student student = new Student();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setPwd(rs.getString("pwd"));
				student.setCre_date(rs.getDate("cre_date"));
				student.setMod_date(rs.getDate("mod_date"));
				
				return student;
			}
		}catch(Exception e){
			throw e;
		}finally{
			try{if(rs != null) rs.close();}catch(SQLException e){}
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){}
		}	
	}
	public int delete(int no) throws Exception{
		Connection con = null;
		PreparedStatement pst = null;
		String query = null;
		
		try{
			con = ds.getConnection();
			query = "delete from student where no = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, no);
			
			return pst.executeUpdate();
			
		}catch(Exception e){
			throw e;
		}finally{
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){}
		}	
	}
	public int insert(Student student) throws Exception{
		System.out.println("StudentDAO insert();");
		PreparedStatement pst = null;
		String query = null;
		Connection con = null;
		try{
			con = ds.getConnection();
			query = "insert into student(name, email, pwd, cre_date, mod_date) values (?, ?, ?, now(), now())";
			pst = con.prepareStatement(query);
			pst.setString(1, student.getName());
			pst.setString(2, student.getEmail());
			pst.setString(3, student.getPwd());
			
			return pst.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally{
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){}
		}	
	}
	public ArrayList<Student> selectAll() throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		
		try{
			con = ds.getConnection();
			query = "select * from student";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			ArrayList<Student> students = new ArrayList<Student>();
			
			while(rs.next()) {
				Student tmp = new Student();
				tmp.setNo(rs.getInt("no"));
				tmp.setName(rs.getString("name"));
				tmp.setEmail(rs.getString("email"));
				tmp.setPwd(rs.getString("pwd"));
				tmp.setCre_date(rs.getDate("cre_date"));
				tmp.setMod_date(rs.getDate("mod_date"));
				
				students.add(tmp);
			}
			return students;
	}catch(Exception e) {
		throw e;
	}finally {
		try{if(rs != null) rs.close();}catch(SQLException e){}
		try{if(st != null) st.close();}catch(SQLException e){}
		try{if(con != null) con.close();}catch(SQLException e){}
	}
	}
	public Student login(String email, String pwd) throws Exception{
		PreparedStatement pst = null;
		String query = null;
		ResultSet rs = null;
		Connection con = null;
		try{
			con = ds.getConnection();
			query = "select * from student where email=? and pwd=?";
			pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, pwd);
			
			rs = pst.executeQuery();
			
			if(!rs.next()) {
				return null;
			}else {
				Student student = new Student();
				student.setEmail(rs.getString("email"));
				student.setName(rs.getString("name"));
				
				return student;
			}
			
		}catch(Exception e){
			throw e;
		}finally{
			try{if(rs != null) rs.close();}catch(SQLException e){}
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){}
	}
}
}