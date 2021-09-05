package ag.demo.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

	@Autowired
	private NumberRepository primeNumberRepo; 
	
	private void saveNumber(Number num) {
		primeNumberRepo.save(num); 
	}
	
	@Override
	public void createNumber(Number num) {
		Number newPrimeNum = new Number(); 
		newPrimeNum.setNumber(num.getNumber());
		saveNumber(newPrimeNum);
	}

	@Override
	public List<Number> getListOfPrimeNumbers(int num) {
		List<Number> filteredPrimeNumbers = new ArrayList<>(); 
		
		if (num != 0 || num > 0) {
			filteredPrimeNumbers = filterByPrimeNumbers(getListOfNumbersLessThenEqual(num), num);
		}
		return filteredPrimeNumbers;
	}
	
	public List<Number> getListOfNumbersLessThenEqual(int num) {
		return primeNumberRepo.findByNumberLessThanEqual(num); 
	}
	
	private List<Number> filterByPrimeNumbers(List<Number> numbers, int num) {
		List<Number> primeNumToReturn = new ArrayList<>();
		
		for (Number n: numbers) {
			if (n.getNumber() < num && isPrimeNumber(n.getNumber())) {
				primeNumToReturn.add(n); 
			}
		}
		return primeNumToReturn; 
	}
	
	private boolean isPrimeNumber(int num) {
		if (num % 2 == 0 || num % 3 == 0) 
			return false; 
		return true; 
	}

	// TODO: check if this method is needed, else remove it 
	private List<Number> getAllNumbers() {
		return primeNumberRepo.findAll();
	}
	
	// TODO: check if this method is needed, else remove 
	public List<Integer> getListOfPrimeIntegers(int num) {
		List<Integer> primeNumbers = new ArrayList<>(); 
		int number = 0; 
		
		for (int i = 0; i <= num; i++) {
			int counter = 0; 
			
			for (number = i; number >= 1; num--) {
				if (i % number == 0) {
					counter += 1; 
				}
			}
			
			if (counter == 2) {
				primeNumbers.add(i); 
				System.out.println("Prime numbers are: " + primeNumbers);
			}
		}
		return primeNumbers;
	}
}
