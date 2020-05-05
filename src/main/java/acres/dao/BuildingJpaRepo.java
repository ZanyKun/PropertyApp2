//package acres.dao;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import acres.dto.BuildingInfo;
//import acres.dto.ReBuildingType;
//
//
//public interface BuildingJpaRepo extends JpaRepository<BuildingInfo, Integer>{
//	
//	@Query("from BuildingInfo")
//	Page<BuildingInfo> findAll(Pageable page);
//	
//	@Query("from BuildingInfo where propertyType = ?1")
//	Page<BuildingInfo> findByPropertyType(String type, Pageable page);
//	
//	BuildingInfo findByBuildingId(int id);
//	
//	@Query("from BuildingInfo where propertyType = ?1 and databaseId = ?2")
//	ReBuildingType findByPropertyTypeAndBuildingId(String dtype, int id);
//}
