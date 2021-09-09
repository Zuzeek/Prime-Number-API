package ag.demo.api.service;

import java.util.List;

import ag.demo.api.model.NumberEntity;

public interface PrimeNumberService {
	
	List<NumberEntity> getAllNumbers();
	List<NumberEntity> addNumbers(NumberEntity num);
	List<NumberEntity> getListOfPrimeNumbers(NumberEntity num); 
}
