package com.clarion.fundonote.exception;

public class BadCredintialException extends RuntimeException
{
	private static final long serialVersionUID = 3672299270553927439L;
	private Integer statusCode;
	private String  description;
	
	public BadCredintialException(Integer statusCode,String description)
	{
		this.statusCode=statusCode;
		this.description=description;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
