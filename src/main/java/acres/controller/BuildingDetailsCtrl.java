package acres.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import acres.dto.BuildingInfo;
import acres.service.BuildingCrudService;

@Controller
public class BuildingDetailsCtrl {
	
	@Autowired	BuildingCrudService buildService;
	
	@GetMapping("/properties/{buildingId}")
//	@PreAuthorize("permitAll()")
	public ModelAndView getBuildingDetails(@PathVariable("buildingId") String buildingId) {
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
