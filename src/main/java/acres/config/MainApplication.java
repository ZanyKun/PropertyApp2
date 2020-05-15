package acres.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "acres")
public class MainApplication{

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}	 
