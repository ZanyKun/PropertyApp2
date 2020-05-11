 package acres.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import acres.dto.BuildingInfo;
import acres.dto.UserInfo;
import acres.service.BuildingCrudService;

@Controller
public class RegisterBuildingCtrl {
	
	@Autowired	BuildingCrudService buildService;
	@Autowired	AmazonS3 s3Client;
	static String bucketname = "99acres-images";
	
	@PostMapping("/insert_property.test")
	public ModelAndView registerBuilding(HttpServletRequest request, @ModelAttribute BuildingInfo building, BindingResult resResult, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		UserInfo user = (UserInfo) request.getAttribute("currentUser");
		String inputRent = request.getParameter("expectedRent");
		String inputPrice = request.getParameter("expectedPrice");
		String listingType = request.getParameter("propertyList");
		String propertyType = request.getParameter("propertyType");
		String[] images = request.getParameterValues("img");
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
				
				if(images.length > 0) {
					
					List<String> imageUrls = new ArrayList<>();
					
					try {
					for(int i = 0; i < images.length; i++) {
						String fileObjKeyName = "buildingImg" + i + "." + request.getParameter("projectName").trim();
						File fileName = new File(images[i]);
						
						PutObjectRequest AWSrequest = new PutObjectRequest(bucketname, fileObjKeyName, fileName);
						ObjectMetadata metadata = new ObjectMetadata();
						metadata.setContentType("image/jpeg");
						metadata.addUserMetadata("Building Image " + i, "Image for " + request.getParameter("projectName"));
						AWSrequest.setMetadata(metadata);
						s3Client.putObject(AWSrequest);
						S3Object savedObj = s3Client.getObject(bucketname, fileObjKeyName);
						String url = savedObj.getKey();
						imageUrls.add(url);
						
					}
					}catch(AmazonServiceException e) {
						e.printStackTrace();
					}catch(SdkClientException e) {
						e.printStackTrace();
					}
				
				float rent = Float.parseFloat(inputRent);
				building.setExpectedRent(rent);
				building.setUser(user);
				building.setPostedDate(postedDate);
				building.setImageUrls(imageUrls);
				buildService.insertBuilding(building);
				session.setAttribute("building", building);
				mv.setViewName("listingComplete");
				
				}
			}
		}
		
		return mv;
	}
	
	@GetMapping("/list_property.test")
	public ModelAndView getBuildingForm() {
		return new ModelAndView("buildingForm");
	}
}
