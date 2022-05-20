package com.ojas.emp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Exception Handler method added in EmployeeController to
	// handle EmployeeAlreadyExistsException exception
	@ExceptionHandler(value = EmployeeAlreadyExistsException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public @ResponseBody ErrorResponse handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}

	@ExceptionHandler(value = NoSuchEmployeeExistsException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleException(NoSuchEmployeeExistsException ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

}
