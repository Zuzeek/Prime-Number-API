package ag.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/")
@RestController
public class PrimeNumberController {
	
	@Autowired
	private PrimeNumberService numberService; 
	
	// Get a Vehicle by: brand, colour -> filter method
	@GetMapping(value = "/{number}")
	public List<Number> getPrimeNumbers (@PathVariable(value = "number") int number) {
		
		return numberService.getListOfPrimeNumbers(number);  
	}
	
	@GetMapping(value = "/numbers")
	public List<Number> getAllNumbers () {
		return numberService.getAllNumbers(); 
	}
	
	
}
