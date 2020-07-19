package by.svirski.lesson6_1.model.exception;

public class CustomSelectionException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CustomSelectionException() {
	}

	public CustomSelectionException(String message) {
		super(message);
	}

	public CustomSelectionException(Throwable cause) {
		super(cause);
	}

	public CustomSelectionException(String message, Throwable cause) {
		super(message, cause);
	}

}
