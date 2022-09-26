package lu.atozdigital.api.exception;

public class ApiRestException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ApiRestException (String message) {
		super(message);
	}
	
	public ApiRestException (String message, Throwable cause) {
		super(message, cause);
	}
}
