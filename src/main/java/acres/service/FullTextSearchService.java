package acres.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import acres.dto.BuildingInfo;

public class FullTextSearchService {
	
	@Autowired	RestHighLevelClient client;
	
	@GetMapping("advance_search.test")
	public List<BuildingInfo> getBuildings(@RequestParam("keyword") String keyword, HttpServletRequest request) throws IOException{
		SearchSourceBuilder source = new SearchSourceBuilder();
		source.from(0);
		source.size(8);
		
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		searchSourceBuilder.query(QueryBuilders.multiMatchQuery(keyword, "projectName", "description"));
		searchSourceBuilder.query(QueryBuilders.termsQuery("projectName", keyword).boost(5f));
		
		if(!request.getParameter("propertyType").equals("0")) {
			searchSourceBuilder.postFilter(QueryBuilders.termsQuery("propertyType", request.getParameter("propertyType")));
		}
		if(!request.getParameter("listingType").equals("0")) {
			searchSourceBuilder.postFilter(QueryBuilders.termsQuery("listingType", request.getParameter("listingType")));
		}
		if(!request.getParameter("constructionStatus").equals("0")) {
			searchSourceBuilder.postFilter(QueryBuilders.termsQuery("availability", request.getParameter("constructionStatus")));
		}
		if(!request.getParameter("state").equals("0")) {
			searchSourceBuilder.postFilter(QueryBuilders.termsQuery("state", request.getParameter("state")));
		}
		
			
		
		SearchRequest searchRequest = new SearchRequest("properties");
		searchRequest.source(searchSourceBuilder);
		
		
		
		//Getting information from elastic search
		SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		SearchHits hits = searchResponse.getHits();
		
		SearchHit[] propertiesHit = hits.getHits();
		
		List<BuildingInfo> buildings = new ArrayList<>();
		
		return null;
	}
}
