package ag.demo.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.primes.Primes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ag.demo.api.model.NumberEntity;
import ag.demo.api.repo.NumberRepository;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

	@Autowired
	private NumberRepository numberRepo; 
	
	private void saveNumber(NumberEntity num) {
		 numberRepo.save(num); 
	}
	
	@Override
	public void addNumbers(int num) {
		List<NumberEntity> numbers = new ArrayList<>(); 
		
		for (int i = 0; i < num; i++) {
			NumberEntity number = new NumberEntity();
			number.setNumber(i); 
			saveNumber(number);
			numbers.add(number); 
		}
	}

	/**
	 *  TODO: handle exceptions, add validation
	 */
	@Override
	public List<NumberEntity> getListOfPrimeNumbers(int num) {
		List<NumberEntity> primeNumbers = new ArrayList<>(); 
		
		if (num != 0 || num > 0) {
			primeNumbers = filterByPrimeNumbers(getListOfNumbersLessThenEqual(num), num);
		}
		return primeNumbers;
	}
	
	public List<NumberEntity> getListOfNumbersLessThenEqual(int num) {
		return numberRepo.findByNumberLessThanEqual(num); 
	}
	
	private List<NumberEntity> filterByPrimeNumbers(List<NumberEntity> numbers, int num) {
		List<NumberEntity> primeNumToReturn = new ArrayList<>();
		
		for (NumberEntity n: numbers) {
			if (n.getNumber() <= num && Primes.isPrime(n.getNumber())) {
				primeNumToReturn.add(n); 
			}
		}
		return primeNumToReturn; 
	}

	@Override
	public List<NumberEntity> getAllNumbers() {
		return numberRepo.findAll();
	}
}
