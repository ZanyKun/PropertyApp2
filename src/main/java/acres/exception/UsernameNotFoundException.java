package acres.exception;

public class UsernameNotFoundException extends RuntimeException {
	
	public UsernameNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	private static final long serialVersionUID = 1L;

	
}
