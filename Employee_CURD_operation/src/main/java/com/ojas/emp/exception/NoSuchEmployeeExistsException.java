package com.ojas.emp.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSuchEmployeeExistsException extends RuntimeException {

	private String message;

	// Arg constructor
	public NoSuchEmployeeExistsException(String message) {
		super(message);
		this.message = message;
	}

}
