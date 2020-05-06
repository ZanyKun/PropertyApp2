package acres.controller;
//package acres.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import acres.dto.BuildingInfo;
//import acres.dto.ComBuildingType;
//import acres.dto.ReBuildingType;
//import acres.service.ElasticSearchService;
//import acres.service.JpaBuildingService;
//
//@Controller
//public class SearchBuildingController {
//	@Autowired 	JpaBuildingService buildService;
//	@Autowired	ElasticSearchService elastic;
//	
//	@GetMapping("list_properties.test")
//	public ModelAndView getAllProperties() {
//		ModelAndView mv = new ModelAndView("properties");
//		Pageable pageable = PageRequest.of(0, 6);
//		Page<BuildingInfo> page = buildService.getAllBuildings(pageable);
//		List<BuildingInfo> buildingList = page.getContent();
//		System.out.println(buildingList);
//		mv.addObject("buildings", buildingList);
//		return mv;
//	}
//	
//	@GetMapping("residential_properties.test")
//	public ModelAndView getResidentialProperties() {
//		ModelAndView mv = new ModelAndView("properties");
//		Pageable pageable = PageRequest.of(0, 6);
//		Page<BuildingInfo> page = buildService.getAllResidentialBuildings(pageable);
//		List<BuildingInfo> buildingList = page.getContent();
//		System.out.println(buildingList);
//		mv.addObject("buildings", buildingList);
//		return mv;
//	}
//	
//	@GetMapping("commercial_properties.test")
//	public ModelAndView getCommercialProperties() {
//		ModelAndView mv = new ModelAndView("properties");
//		Pageable pageable = PageRequest.of(0, 6);
//		Page<BuildingInfo> page = buildService.getAllCommercialBuildings(pageable);
//		List<BuildingInfo> buildingList = page.getContent();
//		System.out.println(buildingList);
//		mv.addObject("buildings", buildingList);
//		return mv; 
//	}
//	
//	@GetMapping("property_details.test")
//	public ModelAndView getBuildingDetails(HttpServletRequest request) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("property_details");
//		String propertyType = request.getParameter("propertyType");
//		int buildingId = Integer.parseInt(request.getParameter("databaseId"));
//		
//		if(propertyType.equals("Residential")) {
//			BuildingInfo buildDetails = buildService.findByBuildingId(buildingId);
//			ReBuildingType retBuilding = buildService.getResidentialDetails(buildingId);
//			mv.addObject("buildingInfo", buildDetails);
//			mv.addObject("retBuilding", retBuilding); 
//		}
//		else {
//			BuildingInfo buildDetails = buildService.findByBuildingId(buildingId);
//			ComBuildingType retBuilding = buildService.getCommercialDetails(buildingId);
//			mv.addObject("buildingInfo", buildDetails);
//			mv.addObject("retBuilding", retBuilding);
//		}
//		
//		return mv;
//	}
//	
//	@GetMapping("advance_search.test")
//	public ModelAndView advanceSearch(HttpServletRequest request) {
//		ModelAndView mv = new ModelAndView("properties");
//		List<BuildingInfo> buildings = elastic.advanceSearchBuildingInfo(request.getParameter("userInput"));
//		mv.addObject("buildings", buildings);
//		
//		return mv;
//	}
//}
