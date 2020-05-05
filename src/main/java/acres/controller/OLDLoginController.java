package acres.controller;
//package acres.controller;
//
//import java.util.Optional;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;
//
//import acres.dto.UserInfo;
//import acres.exception.UsernameNotFoundException;
//import acres.service.UserAuthenticationService;;
//
//@Controller
//@SessionAttributes("currentUser")
//public class LoginController {
//	
//	@Autowired UserAuthenticationService userAuth;
//	
//	@PostMapping("authenticate.test")
//	public ModelAndView confirmUser(@ModelAttribute UserInfo currentUser, BindingResult result, HttpSession session) throws UsernameNotFoundException {
//		ModelAndView mv = new ModelAndView();
//		
//		if(result.hasErrors()) {
//			mv.setViewName("login");
//			mv.addObject("userError", "<p style='color: red'>No information has been provided.</p>");
//		}
//		else {
//			int confirmStatus = 1;
//			
//			if(!userAuth.authenticateUser(currentUser)) {
//				mv.setViewName("login");
//				mv.addObject("userError", "<p style='color: red'>The username does not exist.</p><br/>");
//				confirmStatus = -1;
//				throw new UsernameNotFoundException();
//			}
//			
//			if(confirmStatus == 1) {
//				Optional<UserInfo> dbUser = userAuth.retrieveUser(currentUser);
//				if(dbUser.isPresent()) {
//					UserInfo dbValues = dbUser.get();
//					String dbPass = dbValues.getPassword1();
//					String inputPass = currentUser.getPassword1();
//					if(!dbPass.equals(inputPass)) {
//						mv.setViewName("login");
//						mv.addObject("userError", "<p style='color: red'>The password is incorrect</p>");
//					}
//					else {
//						mv.setViewName("loginComplete");
//						session.setAttribute("currentUser", currentUser);
//					}
//				}
//			}
//		}
//		return mv;
//	}
//	
//	@GetMapping(name = "login.test")
//	public ModelAndView getLoginPage() {
//		return new ModelAndView("login");
//	}
//}
