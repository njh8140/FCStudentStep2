package controls;

import java.util.Map;

import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		session.invalidate();
		return "redirect:login.do";
	}
}