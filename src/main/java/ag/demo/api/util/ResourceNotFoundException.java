package ag.demo.api.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) 
public class ResourceNotFoundException extends RuntimeException  {
	
	private String field;
	private String message;
	
	public ResourceNotFoundException(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	} 
	
	
}
