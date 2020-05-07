package acres.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import acres.dto.BuildingInfo;
import acres.service.BuildingCrudServiceImpl;

@RestController
public class BuildingDetailsCtrl {
	
	@Autowired	BuildingCrudServiceImpl buildService;
	
	@GetMapping("/properties/{buildingId}")
	public ModelAndView getBuildingDetails(@RequestParam("buildingId") String buildingId) {
		ModelAndView mv = new ModelAndView();
		Optional<BuildingInfo> retBuilding = buildService.getBuilding(buildingId);
		if(!retBuilding.isPresent()) {
			mv.setViewName("404");
		}
		else {
			BuildingInfo building = retBuilding.get();
			mv.setViewName("property_details");
			mv.addObject("buildingInfo", building);
		}
		
		return mv;
	}
}
