package ag.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ag.demo.api.model.NumberEntity;
import ag.demo.api.service.PrimeNumberService;

@RequestMapping(value = "/")
@RestController
public class PrimeNumberController {
	
	@Autowired
	private PrimeNumberService numberService; 
	
	@GetMapping(value = "/{number}")
	public List<NumberEntity> getPrimeNumbers (@PathVariable(value = "number") int number) {
		return numberService.getListOfPrimeNumbers(number);  
	}
	
	@GetMapping(value = "/numbers")
	public List<NumberEntity> getAllNumbers () {
		return numberService.getAllNumbers(); 
	}
	
}
