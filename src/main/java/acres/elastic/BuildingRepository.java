package acres.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.transaction.annotation.Transactional;

import acres.dto.BuildingInfo;

@Transactional
public interface BuildingRepository extends ElasticsearchRepository<BuildingInfo, String>{
	
}
