package acres.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import acres.dto.BuildingInfo;
import acres.dto.UserInfo;
import acres.service.BuildingCrudService;

@Controller
public class RegisterBuildingCtrl {
	
	@Autowired	BuildingCrudService buildService;
	
	@PostMapping("/insert_property.test")
	public ModelAndView registerBuilding(HttpServletRequest request, @ModelAttribute BuildingInfo building, BindingResult resResult, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		UserInfo user = (UserInfo) request.getAttribute("currentUser");
		String inputRent = request.getParameter("expectedRent");
		String inputPrice = request.getParameter("expectedPrice");
		String listingType = request.getParameter("propertyList");
		String propertyType = request.getParameter("propertyType");
		Date postedDate = new Date();
		
		if(session.getAttribute("currentUser") == null) {
			mv.setViewName("buildingForm");
			mv.addObject("error", "Please log in to successfully list a property");
		}
		else if(propertyType == null) {
			mv.setViewName("buildingForm");
			mv.addObject("error", "<p>No information has been provided</p>");
		}
		else if(listingType.equals("Sale")) {
			if(inputPrice.equals("")) {
				mv.setViewName("buildingForm");
				mv.addObject("error", "<p>Please provide a price for your property</p>");
			}
			else {
				float price = Float.parseFloat(inputPrice);
				building.setExpectedPrice(price);
				building.setUser(user);
				building.setPostedDate(postedDate);
				buildService.insertBuilding(building);
				session.setAttribute("building", building);
				mv.setViewName("listingComplete");
			}
		}
		else if(listingType.equals("Rent")) {
			if(inputRent == null) {
				mv.setViewName("buildingForm");
				mv.addObject("error", "<p>Please provide expected rent for your property</p>");
			}
			else {
				float rent = Float.parseFloat(inputRent);
				building.setExpectedRent(rent);
				building.setUser(user);
				building.setPostedDate(postedDate);
				buildService.insertBuilding(building);
				session.setAttribute("building", building);
				mv.setViewName("listingComplete");
				
			}
		}
		return mv;
	}
	
	@GetMapping("/list_property.test")
	public ModelAndView getBuildingForm() {
		return new ModelAndView("buildingForm");
	}
}
