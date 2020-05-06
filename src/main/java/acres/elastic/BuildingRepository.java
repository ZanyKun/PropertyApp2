package acres.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import acres.dto.BuildingInfo;

public interface BuildingRepository extends ElasticsearchRepository<BuildingInfo, String>{
	
}
