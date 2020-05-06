package acres.service;
//package acres.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import acres.dao.BuildingJpaRepo;
//import acres.dto.BuildingInfo;
//import acres.dto.ComBuildingType;
//import acres.dto.ReBuildingType;
//
//
//@Service
//public class JpaBuildingServiceImpl implements JpaBuildingService{
//	
//	@Autowired BuildingJpaRepo buildRepo;
//	
//	public void insertResidentialBuilding(ReBuildingType r) {
//		buildRepo.save(r);
//	}
//	
//	public void insertCommercialBuilding(ComBuildingType c) {
//		buildRepo.save(c);
//	}
//	
//	@Override
//	public Page<BuildingInfo> getAllBuildings(Pageable page) {
//		return buildRepo.findAll(page);
//	}
//
//	@Override
//	public Page<BuildingInfo> getAllResidentialBuildings(Pageable page) {
//		return buildRepo.findByPropertyType("Residential", page);
//	}
//
//	@Override
//	public Page<BuildingInfo> getAllCommercialBuildings(Pageable page) {
//		return buildRepo.findByPropertyType("Commercial", page);
//	}
//
//	@Override
//	public BuildingInfo findByBuildingId(int id) {
//		return buildRepo.findByBuildingId(id);
//	}
//
//	@Override
//	public ReBuildingType getResidentialDetails(int id) {
//		return buildRepo.findByPropertyTypeAndBuildingId("ReBuildingType", id);
//	}
//
//	@Override
//	public ComBuildingType getCommercialDetails(int id) {
//		//TODO
//		return null;
//	}
//	
//}
