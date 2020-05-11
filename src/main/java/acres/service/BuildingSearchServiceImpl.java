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


import acres.dto.BuildingInfo;
import acres.elastic.BuildingRepository;

@Service
public class BuildingSearchServiceImpl {
	
	@Autowired	RestHighLevelClient client;
	@Autowired	BuildingRepository buildRepo;
	
	public List<BuildingInfo> getBuildingsBySearch(String keyword, HttpServletRequest request) throws IOException{
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.from(0);
		searchSourceBuilder.size(8);
		
		BoolQueryBuilder myQuery = settingQuery(keyword, request);
		
		searchSourceBuilder.query(myQuery);
		settingHighlighter(searchSourceBuilder);

		
		SearchRequest searchRequest = new SearchRequest("properties");
		searchRequest.source(searchSourceBuilder);
		
		
		//Getting information from elastic search
		SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		SearchHits hits = searchResponse.getHits();
		
		SearchHit[] propertiesHit = hits.getHits();
		
		List<BuildingInfo> buildingList = new ArrayList<>();
		
		for(SearchHit hit: propertiesHit) {
			Optional<BuildingInfo> buildResult = buildRepo.findById(hit.getId());
			BuildingInfo building = buildResult.get();
			
			Map<String, HighlightField> highlightedFields = hit.getHighlightFields();
			HighlightField projHighlight = highlightedFields.get("projectName");
			HighlightField descHighlight = highlightedFields.get("description");
			if(projHighlight != null) {
				Text[] fragProj = projHighlight.fragments();
				String highlightedProject = "";
				
				for(int i = 0; i < fragProj.length; i++) {
					highlightedProject += fragProj[i].string();
				}
				
				building.setProjectName(highlightedProject);
			}
			if(descHighlight != null) {
				Text[] fragDesc = descHighlight.fragments();
				String highlightedDescription = "";
				
				for(int i = 0; i < fragDesc.length; i++) {
					highlightedDescription += fragDesc[i].string();
				}
				
				building.setDescription(highlightedDescription);
			}
			
			buildingList.add(building);
		}
		
		return buildingList;
	}
	
	public List<BuildingInfo> getBuildingsByPropertyType(String propertyType) throws IOException{
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.from(0);
		searchSourceBuilder.size(8);
		searchSourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("propertyType", propertyType)));
		
		SearchRequest request = new SearchRequest("properties");
		request.source(searchSourceBuilder);
		
		SearchResponse response = client.search(request, RequestOptions.DEFAULT);
		SearchHits hits = response.getHits();
		SearchHit[] propertiesHit = hits.getHits();
		long totalHits = hits.totalHits;
		System.out.println(totalHits);
		
		List<BuildingInfo> buildingList = new ArrayList<>();
		
		for(SearchHit hit: propertiesHit) {
			Optional<BuildingInfo> buildResult = buildRepo.findById(hit.getId());
			BuildingInfo building = buildResult.get();
			buildingList.add(building);
		}
		
		return buildingList;
	}
	
 	private BoolQueryBuilder settingQuery(String keyword, HttpServletRequest request) {
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
			QueryBuilder projectFuzzy = QueryBuilders.multiMatchQuery(keyword, "projectName", "description").fuzzyTranspositions(true);
			myQuery.must(projectFuzzy);
		}
		if(listingType != null) {
			QueryBuilder listingMatch = QueryBuilders.termQuery("propertyList", listingType);
			myQuery.should(listingMatch);
		}
		if(propertyType != null) {
			QueryBuilder propertyMatch = QueryBuilders.termQuery("propertyType", propertyType);
			myQuery.should(propertyMatch);
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
			myQuery.should(budgetRange);
			myQuery.should(rentRange);
		}
		else if (listingType.equals("Sale")) {
			QueryBuilder budgetRange = QueryBuilders.rangeQuery("expectedPrice").gte(minBudget).lte(maxBudget);
			myQuery.should(budgetRange);
		}
		else if(listingType.equals("Rent")) {
			QueryBuilder budgetRange = QueryBuilders.rangeQuery("expectedRent").gte(minBudget).lte(maxBudget);
			myQuery.should(budgetRange);
		}
		return myQuery;
	}

	private void settingHighlighter(SearchSourceBuilder searchSourceBuilder) {
		HighlightBuilder highlightBuilder = new HighlightBuilder();
		HighlightBuilder.Field highlightProjectName = new HighlightBuilder.Field("projectName");
		highlightProjectName.highlighterType("unified").preTags("<b style='color: #6CADFF'>").postTags("</b>");
		highlightBuilder.field(highlightProjectName);
		HighlightBuilder.Field highlightDescription =new HighlightBuilder.Field("description");
		highlightDescription.highlighterType("unified").preTags("<b style='color: #6CADFF'>").postTags("</b>");
		highlightBuilder.field(highlightDescription);
		searchSourceBuilder.highlighter(highlightBuilder);
	}

}
