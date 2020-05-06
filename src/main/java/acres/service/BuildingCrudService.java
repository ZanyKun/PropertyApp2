package acres.service;

import java.util.Optional;

import acres.dto.BuildingInfo;

public interface BuildingCrudService {
	void insertBuilding(BuildingInfo b);
	Optional<BuildingInfo> getBuilding(String id);
}
