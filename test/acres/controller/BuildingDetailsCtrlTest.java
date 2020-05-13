package acres.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import acres.dto.BuildingInfo;
import acres.service.BuildingCrudServiceImpl;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BuildingDetailsCtrl.class)
public class BuildingDetailsCtrlTest {
	
	@MockBean	BuildingCrudServiceImpl service;
	static 		Optional<BuildingInfo> building = Optional.of(new BuildingInfo());
	@Autowired	MockMvc mvc;
	@Mock		HttpServletRequest request;
	
	@Test
	public void testGettingNullBuilding() throws Exception {
		when(service.getBuilding("1")).thenReturn(Optional.empty());
		mvc.perform(get("/properties/1")).andExpect(view().name("404")).andExpect(model().size(0));
	}
	
	@Test
	public void testGettingABuilding() throws Exception{
		when(service.getBuilding("2")).thenReturn(building);
		mvc.perform(get("/properties/2")).andExpect(view().name("property_details")).andExpect(model().size(1));
	}
	
}

//@TestConfiguration
//class DetailsConfig{
//	
//	@Bean
//	public BuildingDetailsCtrl ctrl() {
//		return new BuildingDetailsCtrl();
//	}
//}