package ag.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/")
@RestController
public class PrimeNumberController {
	
	@Autowired
	private PrimeNumberService numService; 
	
	
}
