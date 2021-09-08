package ag.demo.api.service;

import java.util.List;

import ag.demo.api.model.NumberEntity;

public interface PrimeNumberService {
	
	List<NumberEntity> getAllNumbers();
	void addNumbers(NumberEntity num);
	List<NumberEntity> getListOfPrimeNumbers(NumberEntity num); 
}
