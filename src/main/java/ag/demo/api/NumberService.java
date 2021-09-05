package ag.demo.api;

import java.util.List;

public interface NumberService {
	
	public void addNumber (int num); 
	public List<Integer> getPrimeNumber (int num); 
	public void deleteNumber (int num); 
}
