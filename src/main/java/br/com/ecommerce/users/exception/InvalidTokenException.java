package br.com.ecommerce.users.exception;

public class InvalidTokenException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidTokenException(String message) {
		super(message.isBlank() ? "Invalid token" : message);
	}
}