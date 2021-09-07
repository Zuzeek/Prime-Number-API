package ag.demo.api.service;

import java.util.List;

import ag.demo.api.model.NumberEntity;

public interface PrimeNumberService {
	
	void createNumber(NumberEntity num); 
	List<NumberEntity> getListOfPrimeNumbers(int num);
	List<NumberEntity> getAllNumbers();
}
