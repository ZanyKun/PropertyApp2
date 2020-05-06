package acres.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import acres.dto.UserInfo;
import acres.exception.UsernameNotFoundException;
import acres.service.UserAuthService;

@Controller
@SessionAttributes("currentUser")
public class LoginController {
	
	@Autowired	UserAuthService userAuth;
	
	@PostMapping("/authenticate.test")
	public ModelAndView confirmUser(@ModelAttribute UserInfo currentUser, BindingResult result, HttpSession session) throws UsernameNotFoundException {
		ModelAndView mv = new ModelAndView();
		
		try {if(result.hasErrors()) {
			mv.setViewName("login");
			mv.addObject("userError", "<p style='color: red'>No information has been provided.</p>");
		}
		else {
			int confirmStatus = 1;
			if(!userAuth.isUserPresent(currentUser.getUsername())){
				mv.setViewName("login");
				mv.addObject("userError", "<p style='color: red'>The username does not exist.</p>");
				confirmStatus = -1;
				throw new UsernameNotFoundException("Username does not appear in database");
			}
			
			if(confirmStatus == 1) {
				Optional<UserInfo> dbUser = userAuth.getUserDetails(currentUser.getUsername());
				if(dbUser.isPresent()) {
					UserInfo dbValues = dbUser.get();
					String dbPass = dbValues.getPassword1();
					String inputPass = currentUser.getPassword1();
					if(!dbPass.equals(inputPass)) {
						mv.setViewName("login");
						mv.addObject("userError", "<p style='color: red'>The password is incorrect</p>");
					}
					else {
						mv.setViewName("loginComplete");
						session.setAttribute("currentUser", currentUser);
					}
				}
			}
		}
		}catch(UsernameNotFoundException e) {
			e.getMessage();
		}
		
		return mv;
	}
	
	
	@GetMapping("/login.test")
	public ModelAndView getLoginPage() {
		return new ModelAndView("login");
	}
}
