package acres.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import acres.dto.BuildingInfo;
import acres.service.BuildingSearchServiceImpl;

@Controller
public class SearchBuildingCtrl {
	
	@Autowired	BuildingSearchServiceImpl buildService;
	
	@GetMapping("/advance_search.test")
	public ModelAndView getBuildingsBySearch(@RequestParam("keyword") String keyword, HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("properties");
		System.out.println(keyword);
		List<BuildingInfo> retBuildings = buildService.getBuildings(keyword, request);
		System.out.println(retBuildings);
		if(!retBuildings.isEmpty()) {
			mv.addObject("buildings", retBuildings);
		}
		else {
			mv.addObject("noBuildings", "<h3>No buildings were found for this search criteria</h3>");
		}
		return mv;
	}
	
}
