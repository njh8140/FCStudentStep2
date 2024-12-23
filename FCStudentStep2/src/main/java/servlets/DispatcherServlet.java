package servlets;

import java.io.IOException;
import java.util.HashMap;

import controls.Controller;
import controls.LoginController;
import controls.LogoutController;
import controls.StudentAddController;
import controls.StudentDeleteController;
import controls.StudentListController;
import controls.StudentUpdateController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Student;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		System.out.println("servletPath :"+ servletPath);
		
		try {
			ServletContext sc = this.getServletContext();
			HashMap<String, Object> model = new HashMap<String, Object>();
			
			model.put("studentDao", sc.getAttribute("studentDao"));
			
			//String pageController = null;
			Controller pageController = null;
			
			if(servletPath.equals("/student/list.do")) {
				//pageController = "/student/list";
				pageController = new StudentListController();
			} else if(servletPath.equals("/student/add.do")) {
				//pageController = "/student/add";
				pageController = new StudentAddController();
				if(request.getParameter("email") != null) {
					Student student = new Student();
					student.setName(request.getParameter("name"));
					student.setEmail(request.getParameter("email"));
					student.setPwd(request.getParameter("pwd"));
					
					//request.setAttribute("student", student);
					model.put("student", student);
				}
			} else if(servletPath.equals("/student/update.do")) {
				//pageController = "/student/update";
				pageController = new StudentUpdateController();
				if(request.getParameter("email") != null) {
					Student student = new Student();
					student.setNo(Integer.parseInt(request.getParameter("no")));
					student.setName(request.getParameter("name"));
					student.setEmail(request.getParameter("email"));
					student.setPwd(request.getParameter("pwd"));
					
					//request.setAttribute("student", student);
					model.put("student", student);
				} else {
					model.put("no", Integer.parseInt(request.getParameter("no")));
				}
					
			} else if(servletPath.equals("/student/delete.do")) {
				//pageController = "/student/delete";
				pageController = new StudentDeleteController();
				model.put("no", Integer.parseInt(request.getParameter("no")));
			} else if(servletPath.equals("/auth/login.do")) {
				//pageController = "/auth/login";
				pageController = new LoginController();
				if(request.getParameter("email") != null) {
					Student loginInfo = new Student();
					loginInfo.setEmail(request.getParameter("email"));
					loginInfo.setPwd(request.getParameter("pwd"));
					
					model.put("loginInfo", loginInfo);
					model.put("session", request.getSession());
				}
			} else if(servletPath.equals("/auth/logout.do")) {
				//pageController = "/auth/logout";
				pageController = new LogoutController();
				model.put("session", request.getSession());
			}
			//RequestDispatcher rd = request.getRequestDispatcher(pageController);
			//rd.include(request, response);
			String viewUrl = pageController.execute(model);
			
			//String viewUrl = (String)request.getAttribute("viewUrl");
			System.out.println("viewUrl : "+viewUrl);
			
			for(String key: model.keySet()) {
				System.out.println("key***"+key);
				request.setAttribute(key, model.get(key));
			}
			
			if(viewUrl.startsWith("redirect:")) {
				String url = viewUrl.substring(9);
				System.out.println(url);
				response.sendRedirect(url);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}
			System.out.println("=========================");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
}
}