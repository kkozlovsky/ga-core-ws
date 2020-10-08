package ga.core.web.exception;

public class WrongPasswordException extends RuntimeException {

	public WrongPasswordException(String message) {
		super(message);
	}

}
