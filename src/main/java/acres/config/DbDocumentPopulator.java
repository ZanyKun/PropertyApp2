package acres.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import acres.dao.BuildingJpaRepo;
import acres.dao.DocumentRepository;
import acres.dto.BuildingInfo;

@Profile("!prod")
@Component
public class DbDocumentPopulator implements CommandLineRunner{
	
	@Autowired 	DocumentRepository docuRepo;
	@Autowired	BuildingJpaRepo	buildRepo;
	
	@Override
	public void run(String... args) throws Exception {
		BuildingInfo b1 = new BuildingInfo("Rent", "Commercial", "555 N State St.", "Chicago", "IL", "ABC Properties Inc.",
				"This is a description for this beautiful apartment building.", "0-1 year old", 1200f);
		BuildingInfo b2 = new BuildingInfo("Rent", "Residential", "2323 W. Montrose Ave.", "Chicago", "IL", "Monkey Properties Inc.",
				"This is a wild wild WILD property located in downtown Chicago.", "3-4 year old", 1500f);
		BuildingInfo b3 = new BuildingInfo("Sell", "Commercial", "2323 W. Montrose Ave.", "Town", "OK", "Money Properties Inc.",
				"This is a property somewhere in Oklahoma", "3-4 year old", 1500f);
		
		buildRepo.save(b1);
		buildRepo.save(b1);
		
		buildRepo.save(b2);
		buildRepo.save(b2);
		
		buildRepo.save(b3);
		buildRepo.save(b3);
	}

}
