package acres.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@ComponentScan(basePackages = "acres")
public class MainApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}	 
