package acres.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import acres.config.WebSecurityConfig;

@RunWith(SpringRunner.class)
@Import(WebSecurityConfig.class)
@WebMvcTest(controllers = LoginController.class)
public class LoginControllerTest {
	
	@Autowired	MockMvc mvc;
	
	@Test
	public void testGettingLoginPage() throws Exception {
		mvc.perform(get("/login.test")).andExpect(view().name("login"));
	}
}

//@TestConfiguration
//class LoginConfig{
//
//	@Bean
//	public LoginController loginCtrl() {
//		return new LoginController();
//	}
//}