package acres.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import acres.dto.BuildingInfo;
import acres.dto.ComBuildingType;
import acres.dto.ReBuildingType;

public interface JpaBuildingService {
	
	void insertResidentialBuilding(ReBuildingType r);
	
	void insertCommercialBuilding(ComBuildingType c);
	
	Page<BuildingInfo> getAllBuildings(Pageable page);
	
	Page<BuildingInfo> getAllResidentialBuildings(Pageable page);
	
	Page<BuildingInfo> getAllCommercialBuildings(Pageable page);
	
	BuildingInfo findByBuildingId(int id);
	
	ReBuildingType getResidentialDetails(int id);
	
	ComBuildingType getCommercialDetails(int id);
}
