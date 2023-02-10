package br.com.unils.ticket.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistingRecordException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExistingRecordException(String msg) {
		super(msg);
	}
}
