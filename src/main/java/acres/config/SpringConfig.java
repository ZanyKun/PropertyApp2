package acres.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

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
	
	@Bean
	public AWSCredentials credentials() {
		AWSCredentials credentials = new BasicAWSCredentials("AKIAI56BHRTP4PNJH6KA", "CykSK2195h1celib8VdUbsWo9lEZ0xW0cQ7BZ9Db");
		return credentials;
	}
	
	@Bean
	public AmazonS3 s3Client() {
		AmazonS3 s3client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials())).disableChunkedEncoding().withRegion(Regions.US_EAST_2).build();
		return s3client;
	}
}
