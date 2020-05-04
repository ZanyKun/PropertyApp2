package acres.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	
	@GetMapping("logout.test")
	public void logoutUser(HttpSession session, HttpServletResponse response) throws IOException {
		session.invalidate();
		response.sendRedirect("../99Acres/welcome.jsp");
	}
}
