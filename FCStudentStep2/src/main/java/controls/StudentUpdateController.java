package controls;

import java.util.Map;

import DAO.StudentDao;
import vo.Student;

public class StudentUpdateController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
			StudentDao studentDao = (StudentDao)model.get("studentDao");
			
			if(model.get("student") == null) {
				model.put("student", studentDao.selectOne((Integer)model.get("no")));
				
				return "/student/StudentUpdate.jsp";
			} else {
				Student student = (Student)model.get("student");
				studentDao.update(student);
				
				return "redirect:list.do";
			}
		}
	}