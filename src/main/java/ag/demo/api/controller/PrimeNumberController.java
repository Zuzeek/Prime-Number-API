package ag.demo.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ag.demo.api.model.NumberEntity;
import ag.demo.api.service.PrimeNumberService;

@RequestMapping(value = "/api")
@RestController
public class PrimeNumberController {
	
	@Autowired
	private PrimeNumberService numberService; 
	
	@GetMapping(value = "/number}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NumberEntity>> getPrimeNumbers (@Valid @RequestBody NumberEntity number) {
		try {
			List<NumberEntity> primeNumbers = numberService.getListOfPrimeNumbers(number); 
			
			if (primeNumbers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(primeNumbers, HttpStatus.OK); 
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/numbers",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NumberEntity>> getAllNumbers () {
		try {
			List<NumberEntity> numbers = numberService.getAllNumbers(); 
			
			if (numbers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(numbers, HttpStatus.OK); 
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/add}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NumberEntity>> createNumbers (@Valid @RequestBody NumberEntity number) {
		try {
			return new ResponseEntity<>(numberService.addNumbers(number), HttpStatus.CREATED); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}
}
