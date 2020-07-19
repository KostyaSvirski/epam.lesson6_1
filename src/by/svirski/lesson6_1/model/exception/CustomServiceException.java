package by.svirski.lesson6_1.model.exception;

public class CustomServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomServiceException() {
	}

	public CustomServiceException(String message) {
		super(message);
	}

	public CustomServiceException(Throwable cause) {
		super(cause);
	}

	public CustomServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
