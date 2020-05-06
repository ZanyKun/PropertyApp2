package acres.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acres.dto.BuildingInfo;
import acres.elastic.BuildingRepository;

@Service
public class BuildingCrudServiceImpl implements BuildingCrudService{

	@Autowired	BuildingRepository buildRep;

	@Override
	public void insertBuilding(BuildingInfo b) {
		buildRep.save(b);
		
	}

	@Override
	public Optional<BuildingInfo> getBuilding(String id) {
		return buildRep.findById(id);
	}

}
