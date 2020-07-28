package by.svirski.lesson6_2.model.exception;

public class CustomCommandException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomCommandException() {
	}

	public CustomCommandException(String message) {
		super(message);
	}

	public CustomCommandException(Throwable cause) {
		super(cause);
	}

	public CustomCommandException(String message, Throwable cause) {
		super(message, cause);
	}


}
