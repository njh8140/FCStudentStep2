package controls;

//import java.util.ArrayList;
import java.util.Map;

import DAO.StudentDao;
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletException;
//import vo.Student;

public class StudentListController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		StudentDao studentDao = (StudentDao)model.get("studentDao");
		model.put("students", studentDao.selectAll());
		return "/student/StudentList.jsp";
		
		/*
		 * try{ ServletContext sc = this.getServletContext();
		 * 
		 * StudentDao studentDao = (StudentDao)sc.getAttribute("studentDao");
		 * ArrayList<Student> students = studentDao.selectAll();
		 * 
		 * request.setAttribute("students", students); request.setAttribute("viewUrl",
		 * "/student/StudentList.jsp");
		 * 
		 * }catch(Exception e){ throw new ServletException(e); }
		 * 
		 * return null;
		 */
	}

}