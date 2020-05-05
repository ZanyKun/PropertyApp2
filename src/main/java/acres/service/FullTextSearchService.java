package acres.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import acres.dto.BuildingInfo;

public class FullTextSearchService {
	
	@Autowired	RestHighLevelClient client;
	
	public List<BuildingInfo> getBuildings(String keyword, HttpServletRequest request){
		SearchSourceBuilder source = new SearchSourceBuilder();
		source.query(QueryBuilders.termsQuery("projectName", keyword));
		source.from(0);
		source.size(8);
		
		SearchRequest search = new SearchRequest();
		search.indices("properties");
		search.source(source);
		
		return null;
	}
}
