package acres.service;

import acres.dto.ComBuildingType;
import acres.dto.ReBuildingType;

public interface BuildingCrudService {
	void insertResidentialBuilding(ReBuildingType r);
	void insertCommercialBuilding(ComBuildingType c);
}
