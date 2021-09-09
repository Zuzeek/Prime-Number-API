package ag.demo.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ag.demo.api.DemoPrimeNumberApplication;
import ag.demo.api.model.NumberEntity;
import ag.demo.api.service.PrimeNumberService;

@Component
public class DataLoader implements CommandLineRunner {

	private static final Logger LOG =  LoggerFactory.getLogger(DemoPrimeNumberApplication.class);

	private static final int DATABASE_NUMBER = 100;
	
	@Autowired
	PrimeNumberService numberService; 
	
	@Override
	public void run(String... args) throws Exception {
		
		// preload database 
		LOG.info("Preloading database with integers.");
		
//		for (int i = 1; i < DATABASE_NUMBER; i ++) {
//			numberService.saveNumber(new NumberEntity(i));
//		}
	}
}
