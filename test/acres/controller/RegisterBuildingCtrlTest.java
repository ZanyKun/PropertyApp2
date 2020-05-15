//package acres.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.amazonaws.services.s3.AmazonS3;
//
//import acres.config.WebSecurityConfig;
//import acres.dto.UserInfo;
//import acres.service.BuildingCrudService;
//import acres.service.MyUserDetailsService;
//
//@ExtendWith(SpringExtension.class)
//@Import(WebSecurityConfig.class)
//@WebMvcTest(controllers = RegisterBuildingCtrl.class)
////@ContextConfiguration(classes = MainApplication.class)
//public class RegisterBuildingCtrlTest {
//	
//	@Autowired	MockMvc mvc;
//	@MockBean 	MyUserDetailsService userDetails;
//	@MockBean	BuildingCrudService service;
//	@MockBean	AmazonS3 client;
//	@MockBean	UserInfo user;
//	
////	
////	@BeforeEach
////	public void init() {
////		mvc = MockMvcBuilders.standaloneSetup(new RegisterBuildingCtrl()).build();
////	}
//	
//	@Test
//	public void testUserNotLoggedIn() throws Exception {
////		when(session.getAttribute("currentUser")).thenReturn(null);
//		mvc.perform(post("/insert_property.test")).andExpect(status().isForbidden());
//	}
//	
//	@Test
////	@WithMockUser("user")
//	public void testUserNotLoggedInButPropertyTypeNotProvided() throws Exception {
//		mvc.perform(post("/insert_property.test").sessionAttr("currentUser", user)).andExpect(status().isForbidden());
//	}
//}
//
//
////@TestConfiguration
////class BuildingConfig{
////	
////	@Bean
////	public RegisterBuildingCtrl ctrl() {
////		return new RegisterBuildingCtrl();
////	}
////}