package acres.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import acres.dto.BuildingInfo;

public interface DocumentRepository extends ElasticsearchRepository<BuildingInfo, String>{
	
}
