package acres.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.transaction.annotation.Transactional;

import acres.dto.UserInfo;

@Transactional
public interface UserDocumentRepo extends ElasticsearchRepository<UserInfo, String>{
	
}
