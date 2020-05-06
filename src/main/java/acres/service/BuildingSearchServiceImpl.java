package acres.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import acres.dto.BuildingInfo;
import acres.elastic.BuildingRepository;

@Service
public class BuildingSearchServiceImpl {
	
	@Autowired	RestHighLevelClient client;
	@Autowired	BuildingRepository buildRepo;
	
	public List<BuildingInfo> getBuildings(@RequestParam("keyword") String keyword, HttpServletRequest request) throws IOException{
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.from(0);
		searchSourceBuilder.size(8);
		
		String propertyType = request.getParameter("propertyType");
		String listingType = request.getParameter("listingType");
		String constructionStatus = request.getParameter("constructionStatus");
		String state = request.getParameter("state");
		Object minArea, maxArea, minBudget, maxBudget;
		
		if(request.getParameter("minArea") == "") {
			minArea = null;
		}
		else {
			minArea = Float.parseFloat(request.getParameter("minArea"));
		}
		if(request.getParameter("maxArea") == "") {
			maxArea = null;
		}
		else {
			maxArea = Float.parseFloat(request.getParameter("maxArea"));
		}
		if(request.getParameter("minBudget").trim() == "") {
			minBudget = null;
		}
		else {
			minBudget = Float.parseFloat(request.getParameter("minBudget"));
		}
		if(request.getParameter("maxBudget").trim() == "") {
			maxBudget = null;
		}
		else {
			maxBudget = Float.parseFloat(request.getParameter("maxBudget"));
		}
		
		BoolQueryBuilder myQuery = QueryBuilders.boolQuery();
		
		if(keyword != "") {
			QueryBuilder keywordMatch = QueryBuilders.multiMatchQuery(keyword, "projectName", "description");
			myQuery.must(keywordMatch);
		}
		if(propertyType != null) {
			QueryBuilder propertyMatch = QueryBuilders.termQuery("propertyType", propertyType);
			myQuery.should(propertyMatch);
		}
		if(propertyType != null) {
			QueryBuilder listingMatch = QueryBuilders.termQuery("propertyList", listingType);
			myQuery.should(listingMatch);
		}
		if(constructionStatus != null) {
			QueryBuilder availabilityMatch = QueryBuilders.termQuery("availabity", constructionStatus);
			myQuery.should(availabilityMatch);
		}
		if(state != null) {
			QueryBuilder stateMatch = QueryBuilders.termQuery("state", state);
			myQuery.should(stateMatch);
		}
		
		QueryBuilder areaRange = QueryBuilders.rangeQuery("plotArea").gte(minArea).lte(maxArea);
		
		myQuery.must(areaRange);
		
		
		if(listingType == null) {
			QueryBuilder budgetRange = QueryBuilders.rangeQuery("expectedPrice").gte(minBudget).lte(maxBudget);
			QueryBuilder rentRange = QueryBuilders.rangeQuery("expectedRent").gte(minBudget).lte(maxBudget);
			myQuery.must(budgetRange);
			myQuery.must(rentRange);
		}
		else if (listingType.equals("Sale")) {
			QueryBuilder budgetRange = QueryBuilders.rangeQuery("expectedPrice").gte(minBudget).lte(maxBudget);
			myQuery.must(budgetRange);
		}
		else if(listingType.equals("Rent")) {
			QueryBuilder budgetRange = QueryBuilders.rangeQuery("expectedRent").gte(minBudget).lte(maxBudget);
			myQuery.must(budgetRange);
		}
		
		searchSourceBuilder.query(myQuery);
		settingHighlighter(searchSourceBuilder);

		
		SearchRequest searchRequest = new SearchRequest("properties");
		searchRequest.source(searchSourceBuilder);
		
		
		//Getting information from elastic search
		SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		SearchHits hits = searchResponse.getHits();
		
		SearchHit[] propertiesHit = hits.getHits();
		long totalHits = hits.getTotalHits();
		System.out.println("Number of hits: " + totalHits);
		
		
		List<BuildingInfo> buildingList = new ArrayList<>();
		
		for(SearchHit hit: propertiesHit) {
			Map<String, HighlightField> highlightedFields = hit.getHighlightFields();
			HighlightField highlight = highlightedFields.get("projectName");
			Text[] fragments = highlight.fragments();
			String fragmentString = fragments[0].string();
			
			
			Optional<BuildingInfo> buildResult = buildRepo.findById(hit.getId());
			if(buildResult.isPresent()) {
				BuildingInfo building = buildResult.get();
				System.out.println(building);
				buildingList.add(building);
			}
		}
		
		return buildingList;
	}

	private void settingHighlighter(SearchSourceBuilder searchSourceBuilder) {
		HighlightBuilder highlightBuilder = new HighlightBuilder();
		HighlightBuilder.Field highlightProjectName = new HighlightBuilder.Field("projectName");
		highlightProjectName.highlighterType("unified");
		highlightBuilder.field(highlightProjectName);
		HighlightBuilder.Field highlightDescription =new HighlightBuilder.Field("description");
		highlightBuilder.field(highlightDescription);
		searchSourceBuilder.highlighter(highlightBuilder);
	}

}