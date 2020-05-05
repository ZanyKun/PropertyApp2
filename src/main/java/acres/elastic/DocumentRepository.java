package acres.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import acres.dto.BuildingInfo;

public interface DocumentRepository extends ElasticsearchRepository<BuildingInfo, Integer>{
	
}
