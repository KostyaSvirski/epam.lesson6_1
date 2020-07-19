package by.svirski.lesson6_1.model.exception;

public class CustomValidationException extends Exception {

	private static final long serialVersionUID = 1L;

	private CustomValidationException() {
	}

	private CustomValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	private CustomValidationException(String message) {
		super(message);
	}

	private CustomValidationException(Throwable cause) {
		super(cause);
	}
	
	

}
