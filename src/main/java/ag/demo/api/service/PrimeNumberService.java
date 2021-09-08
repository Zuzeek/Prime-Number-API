package ag.demo.api.service;

import java.util.List;

import ag.demo.api.model.NumberEntity;

public interface PrimeNumberService {
	
	List<NumberEntity> getListOfPrimeNumbers(int num);
	List<NumberEntity> getAllNumbers();
	void addNumbers(int num);
}
