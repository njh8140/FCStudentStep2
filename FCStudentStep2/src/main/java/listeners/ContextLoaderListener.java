package listeners;


import javax.naming.InitialContext;
import javax.sql.DataSource;

import DAO.StudentDao;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("Listener init();");
    	try{
			ServletContext sc = sce.getServletContext();
			
			//Server 자원을 사용하는 방법
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/student"); 
			
			StudentDao studentDao = new StudentDao();
			studentDao.setDataSource(ds);
			sc.setAttribute("studentDao", studentDao);
			
		} catch(Exception e){
			e.printStackTrace();
		}
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Listener destroy();");
    	
    }
}