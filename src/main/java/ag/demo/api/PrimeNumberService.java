package ag.demo.api;

import java.util.List;

public interface PrimeNumberService {
	
	void createNumber(Number num); 
	List<Number> getListOfPrimeNumbers(int num);
	List<Number> getAllNumbers();
}
