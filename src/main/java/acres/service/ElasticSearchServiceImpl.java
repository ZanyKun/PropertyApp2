package acres.service;

import java.util.List;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import acres.dao.DocumentRepository;
import acres.dto.BuildingInfo;

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService{

	@Autowired DocumentRepository docuRep;
	@Autowired ElasticsearchTemplate elastic;

	@Override
	public void saveBuilding(BuildingInfo b) {
		docuRep.save(b);
	}
	
//	@Override
//	public void updateBuilding(BuildingInfo b) {
//		String buildingId = Integer.toString(b.getBuildingId());
//		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchPhraseQuery("buildingId", buildingId)).build();
//		
//		List<BuildingInfo> building = elastic.queryForList(query, BuildingInfo.class);
//		
//		if(building.contains(b.getBuildingId())) {
//			
//		}
//		
//		building = b;
//	}

	@Override
	public List<BuildingInfo> advanceSearchBuildingInfo(String input) {
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(input).field("propertyList").field("propertyType")
				.field("projectName").field("description").field("availability").type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();
		
		List<BuildingInfo> list = elastic.queryForList(query, BuildingInfo.class);
		
		return list;
	}
}
