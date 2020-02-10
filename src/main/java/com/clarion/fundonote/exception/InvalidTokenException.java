package com.clarion.fundonote.exception;

public class InvalidTokenException extends RuntimeException 
{
	private static final long serialVersionUID = 6201211474766267044L;
	private Integer statusCode;
	private String  description;
	
	public InvalidTokenException(Integer statusCode,String description)
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
