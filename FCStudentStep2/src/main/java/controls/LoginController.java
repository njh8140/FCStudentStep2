package controls;

import java.util.Map;

import DAO.StudentDao;
import jakarta.servlet.http.HttpSession;
import vo.Student;

public class LoginController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		if(model.get("loginInfo") == null) {
			return "/auth/LoginForm.jsp";
		} else {
			StudentDao studentDao = (StudentDao)model.get("studentDao");
			Student loginInfo = (Student)model.get("loginInfo");
			Student student = studentDao.login(loginInfo.getEmail(), loginInfo.getPwd());
			
			if(student != null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("student", student);
				
				return "redirect:../student/list.do";
			}else {
				return "/auth/LoginFail.jsp";
			}
		}
	}
}