package ag.demo.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.primes.Primes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

	@Autowired
	private NumberRepository numberRepo; 
	
	private void saveNumber(Number num) {
		numberRepo.save(num); 
	}
	
	@Override
	public void createNumber(Number num) {
		saveNumber(num);
	}

	// TODO: add exception 
	
	@Override
	public List<Number> getListOfPrimeNumbers(int num) {
		List<Number> primeNumbers = new ArrayList<>(); 
		
		if (num != 0 || num > 0) {
			primeNumbers = filterByPrimeNumbers(getListOfNumbersLessThenEqual(num), num);
		}
		return primeNumbers;
	}
	
	public List<Number> getListOfNumbersLessThenEqual(int num) {
		return numberRepo.findByNumberLessThanEqual(num); 
	}
	
	private List<Number> filterByPrimeNumbers(List<Number> numbers, int num) {
		List<Number> primeNumToReturn = new ArrayList<>();
		
		for (Number n: numbers) {
			if (n.getNumber() <= num && Primes.isPrime(n.getNumber())) {
				primeNumToReturn.add(n); 
			}
		}
		return primeNumToReturn; 
	}

	@Override
	public List<Number> getAllNumbers() {
		return numberRepo.findAll();
	}
}
