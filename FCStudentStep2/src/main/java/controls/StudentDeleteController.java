package controls;

import java.util.Map;

import DAO.StudentDao;

public class StudentDeleteController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
			StudentDao studentDao = (StudentDao)model.get("studentDao");
			studentDao.delete((Integer)model.get("no"));
			
			return "redirect:list.do";
		}
	}
