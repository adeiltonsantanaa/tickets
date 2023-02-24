package br.com.unils.ticket.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidEmailException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidEmailException(String msg) {
		super(msg);
	}
}
