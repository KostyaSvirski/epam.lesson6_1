package by.svirski.lesson6_1.model.exception;

public class CustomCreationException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomCreationException() {
	}

	public CustomCreationException(String message) {
		super(message);
	}

	public CustomCreationException(Throwable cause) {
		super(cause);
	}

	public CustomCreationException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
