package acres.controller;
//package acres.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//
//import acres.dto.UserInfo;
//import acres.service.UserAuthenticationService;
//
//@Controller
//public class RegisterController {
//	@Autowired UserAuthenticationService userAuth;
//	
//	@PostMapping("register.test")
//	public ModelAndView registerUser(HttpServletRequest request, @ModelAttribute UserInfo newUser, BindingResult result) {
//		String confirmPass = request.getParameter("password2");
//		int registerStatus = 1;
//		ModelAndView mv = new ModelAndView();
//		
//		
//		mv.addObject("newUser", newUser);
//		
//		if(!(userAuth.retrieveUser(newUser) == null)) {
//			mv.setViewName("register");
//			mv.addObject("existsError", "<p style='color:red'>This username already exists.</p>");
//			registerStatus = -1;
//		}
//		
//		if(newUser.getUsername().equals("")) {
//			mv.setViewName("register");
//			mv.addObject("userError", "<p style='color:red'>A username has not been provided.</p>");
//			registerStatus = -1;
//		}
//		
//		if(newUser.getPassword1().equals("")) {
//			mv.setViewName("register");
//			mv.addObject("passError", "<p style='color:red'>A password has not been provided</p>");
//			registerStatus = -1;
//		}
//		
//		if(!newUser.getPassword1().equals(confirmPass)) {
//			mv.setViewName("register");
//			mv.addObject("matchError", "<p style='color:red'>The passwords do not match</p>");
//			registerStatus = -1;
//		}
//		
//		if(!newUser.getEmail().matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")) {
//			mv.setViewName("register");
//			mv.addObject("emailError", "<p style='color:red'>The provided email is not correct</p>");
//			registerStatus = -1;
//		}
//		
//		if(!newUser.getPhoneNum().matches("[1-9]{1}[0-9]{2}-[0-9]{3}-[0-9]{4}")) {
//			mv.setViewName("register");
//			mv.addObject("phoneError", "<p style='color:red'>Phone number can't begin with 0.</p>");
//			registerStatus = -1;
//		}
//		
//		if(newUser.getUserType() == null) {
//			mv.setViewName("register");
//			mv.addObject("userTypeError", "<p style='color:red'>Please select an option</p>");
//			registerStatus = -1;
//		}
//		
//		if(registerStatus == 1) {
//			userAuth.registerNewUser(newUser);
//			mv.setViewName("registerComplete");
//		}
//		
//		return mv;
//	}
//	
//	@GetMapping("register.test")
//	public ModelAndView getRegisterPage() {
//		return new ModelAndView("register");
//	}
//}
