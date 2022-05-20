package com.ojas.emp.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmployeeAlreadyExistsException extends RuntimeException {

	private String message;

	public EmployeeAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
}
