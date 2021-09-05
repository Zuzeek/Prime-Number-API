package ag.demo.api;

import java.util.List;

public interface PrimeNumberService {
	
	public void createNumber(Number num); 
	public List<Number> getListOfPrimeNumbers(int num);
}
