package com.clarion.fundonote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.clarion.fundonote.response.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandlingController 
{
	@ExceptionHandler(UserExistanceException.class)
	public ResponseEntity<ExceptionResponse> userExistance(UserExistanceException e)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setStatusCode(e.getStatusCode());
		response.setDescription(e.getDescription());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> defaultException(Exception e)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setDescription(e.getMessage());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadCredintialException.class)
	public ResponseEntity<ExceptionResponse> badCredintialExce(BadCredintialException e)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setStatusCode(e.getStatusCode());
		response.setDescription(e.getDescription());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<ExceptionResponse> invalidTokenExce(InvalidTokenException e)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setStatusCode(e.getStatusCode());
		response.setDescription(e.getDescription());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.FAILED_DEPENDENCY);
	}
	
	@ExceptionHandler(VerificationException.class)
	public ResponseEntity<ExceptionResponse> userVerificationExce(VerificationException e)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setStatusCode(e.getStatusCode());
		response.setDescription(e.getDescription());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.FAILED_DEPENDENCY);
	}
}
