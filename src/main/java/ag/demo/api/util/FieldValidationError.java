package ag.demo.api.util;

public class FieldValidationError {
	    
    private String field;
    private String message;
    
    public FieldValidationError(String string, String message) {
        this.field = string;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

