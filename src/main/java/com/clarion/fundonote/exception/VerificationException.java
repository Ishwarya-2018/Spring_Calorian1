package com.clarion.fundonote.exception;

public class VerificationException extends RuntimeException
{
	private static final long serialVersionUID = -2968172216667972666L;
	private Integer statusCode;
	private String  description;
	
	public VerificationException(Integer statusCode,String description)
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
