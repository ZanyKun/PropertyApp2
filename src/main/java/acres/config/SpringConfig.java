package acres.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import acres.filter.RequestFilter;

@Configuration
public class SpringConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css").addResourceLocations("css/");
		registry.addResourceHandler("/js").addResourceLocations("js/");
		registry.addResourceHandler("/img").addResourceLocations("img/");
		registry.addResourceHandler("/scss").addResourceLocations("scss/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestFilter()).addPathPatterns("/");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("welcome");
		registry.addViewController("/welcome").setViewName("welcome");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/register").setViewName("register");
		registry.addViewController("/list_properties").setViewName("list_properties");
		registry.addViewController("/property_details").setViewName("property_details");
	}
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
