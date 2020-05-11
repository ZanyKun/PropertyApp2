package acres.config;

import java.net.UnknownHostException;

import org.elasticsearch.client.RestHighLevelClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableAutoConfiguration
@EnableElasticsearchRepositories(basePackages = "acres.elastic")
@EnableTransactionManagement
@ComponentScan(basePackages = "acres")
@EntityScan(basePackages = "acres.dto")
public class MainApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	@Bean
	public RestHighLevelClient client() throws UnknownHostException {
		ClientConfiguration clientConfiguration = ClientConfiguration.builder()
				.connectedTo("localhost:9230").build();
		
		return RestClients.create(clientConfiguration).rest();
	}	
}	 
