package controls;

import java.util.Map;

import DAO.StudentDao;
import vo.Student;

public class StudentAddController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		if(model.get("student") == null) {
			return "/student/StudentInsert.jsp";
		} else {
			StudentDao studentDao = (StudentDao)model.get("studentDao");
			Student student = (Student)model.get("student");
			studentDao.insert(student);
			
			return "redirect:list.do";
		}
	}
}