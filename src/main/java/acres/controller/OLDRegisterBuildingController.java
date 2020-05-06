package acres.controller;
//package acres.controller;
//
//import java.time.LocalDate;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import acres.dto.ComBuildingType;
//import acres.dto.ReBuildingType;
//import acres.dto.UserInfo;
//import acres.service.ElasticSearchService;
//import acres.service.JpaBuildingService;
//
//@Controller
//public class RegisterBuildingController {
//	
//	@Autowired JpaBuildingService buildService;
//	@Autowired ElasticSearchService elastic;
//	
//	@PostMapping("/insert_property.test")
//	public ModelAndView registerBuilding(HttpServletRequest request, @ModelAttribute ReBuildingType residentialInfo, BindingResult resResult, @ModelAttribute ComBuildingType commercialInfo, BindingResult comResult, HttpSession session) {
//		ModelAndView mv = new ModelAndView();
//		UserInfo user = (UserInfo) request.getAttribute("currentUser");
//		String inputRent = request.getParameter("expectedRent");
//		String inputPrice = request.getParameter("expectedPrice");
//		LocalDate date = LocalDate.now();
//		if(!(inputRent.equals(""))) {
//			float rent = Float.parseFloat(inputRent);
//			commercialInfo.setExpectedRent(rent);
//			residentialInfo.setExpectedRent(rent);
//		}
//		else {
//			float price = Float.parseFloat(inputPrice);
//			residentialInfo.setExpectedPrice(price);
//			commercialInfo.setExpectedPrice(price);
//		}
//		
//		String propertyType = request.getParameter("propertyType");
//		
//		if(session.getAttribute("currentUser") == null) {
//			mv.setViewName("buildingForm");
//			mv.addObject("error", "Please log in to successfully list a property");
//		}
//		else {
//			
//			if(propertyType == null) {
//				mv.setViewName("buildingForm");
//				mv.addObject("error", "<p>No information has been provided</p>");
//			}
//			else if(propertyType.equals("Residential")) {
//					residentialInfo.setUser(user);
//					residentialInfo.setPostedDate(date);
//					buildService.insertResidentialBuilding(residentialInfo);
//					elastic.saveBuilding(residentialInfo);
//					session.setAttribute("residentialInfo", residentialInfo);
//					mv.setViewName("listingComplete");
//			}
//			else if(propertyType.equals("Commercial")) {
//					commercialInfo.setUser(user);
//					commercialInfo.setPostedDate(date);
//					buildService.insertCommercialBuilding(commercialInfo);
//					elastic.saveBuilding(commercialInfo);
//					session.setAttribute("commercialInfo", commercialInfo);
//					mv.setViewName("listingComplete");
//			}
//		}
//		
//		return mv;
//	}
//	
//	@GetMapping("/list_property.test")
//	public ModelAndView getBuildingForm() {
//		return new ModelAndView("buildingForm");
//	}
//}
