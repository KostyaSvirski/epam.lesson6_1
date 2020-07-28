package by.svirski.lesson6_2.model.exception;

public class CustomParseException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomParseException() {
	}

	public CustomParseException(String message) {
		super(message);
	}

	public CustomParseException(Throwable cause) {
		super(cause);
	}

	public CustomParseException(String message, Throwable cause) {
		super(message, cause);
	}

}
