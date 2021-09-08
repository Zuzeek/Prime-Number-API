package ag.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<List<NumberEntity>> getPrimeNumbers (@RequestBody NumberEntity number) {
		return new ResponseEntity<>(numberService.getListOfPrimeNumbers(number), HttpStatus.OK); 
	}
	
	@GetMapping(value = "/numbers",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NumberEntity>> getAllNumbers () {
		return new ResponseEntity<>(numberService.getAllNumbers(), HttpStatus.OK); 
	}
	
	@PostMapping(value = "/add}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NumberEntity>> createNumbers (@RequestBody NumberEntity number) {
		numberService.addNumbers(number);
		return new ResponseEntity<>(HttpStatus.CREATED); 
	}
}
