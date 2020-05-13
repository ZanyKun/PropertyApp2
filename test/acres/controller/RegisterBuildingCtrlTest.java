package acres.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import acres.config.MainApplication;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RegisterBuildingCtrl.class)
@ContextConfiguration(classes = MainApplication.class)
public class RegisterBuildingCtrlTest {
	
	@Autowired 	MockMvc mvc;
	
	@Test
	public void testUserNotLoggedIn() throws Exception {
//		when(session.getAttribute("currentUser")).thenReturn(null);
		mvc.perform(post("/insert_property.test")).andExpect(view().name("buildingForm"));
	}
}


//@TestConfiguration
//class BuildingConfig{
//	
//	@Bean
//	public RegisterBuildingCtrl ctrl() {
//		return new RegisterBuildingCtrl();
//	}
//}