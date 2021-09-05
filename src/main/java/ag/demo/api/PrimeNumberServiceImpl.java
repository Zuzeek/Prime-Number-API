package ag.demo.api;

import java.util.ArrayList;
import java.util.List;

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
		Number newPrimeNum = new Number(); 
		newPrimeNum.setNumber(num.getNumber());
		saveNumber(newPrimeNum);
	}

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
			if (n.getNumber() <= num && isPrimeNumber(n.getNumber())) {
				primeNumToReturn.add(n); 
			}
		}
		return primeNumToReturn; 
	}
	
	private boolean isPrimeNumber(int num) {
		if (num == 2 || num == 3) 
			return true; 
		
		if (num % 2 == 0 || num % 3 == 0) 
			return false; 
		return true; 
	}

	@Override
	public List<Number> getAllNumbers() {
		return numberRepo.findAll();
	}
}
