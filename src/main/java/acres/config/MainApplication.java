package acres.config;

import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "acres.dao", repositoryImplementationPostfix = "CustomImpl")
@EnableElasticsearchRepositories(basePackages = "acres.elastic")
@EnableTransactionManagement
@ComponentScan(basePackages = "acres")
@EntityScan(basePackages = "acres.dto")
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	@Bean
	public Client client() {
		Settings settings = Settings.builder().put("client.transport.sniff", true)
		.put("path.home", "D://kibana-7.6.2-windows-x86_64/elasticsearch-7.6.2")
		.build();
		TransportClient client = new PreBuiltTransportClient(settings);
		client.addTransportAddress(new TransportAddress(new InetSocketAddress("localhost", 9230)));
		return client;
	}
	
	@Bean(name = "elasticsearchTemplate")
	public ElasticsearchOperations getElasticSearchTemplate() {
		return new ElasticsearchTemplate(client());
	}
}
