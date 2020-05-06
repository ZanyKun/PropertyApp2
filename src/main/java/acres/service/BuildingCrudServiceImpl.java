package acres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acres.dto.ComBuildingType;
import acres.dto.ReBuildingType;
import acres.elastic.BuildingRepository;

@Service
public class BuildingCrudServiceImpl implements BuildingCrudService{

	@Autowired	BuildingRepository buildRep;
	
	@Override
	public void insertResidentialBuilding(ReBuildingType r) {
		buildRep.save(r);
		
	}

	@Override
	public void insertCommercialBuilding(ComBuildingType c) {
		buildRep.save(c);
	}

}
