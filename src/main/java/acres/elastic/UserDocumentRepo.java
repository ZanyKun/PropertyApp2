package acres.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import acres.dto.UserInfo;

public interface UserDocumentRepo extends ElasticsearchRepository<UserInfo, String>{
	
}
