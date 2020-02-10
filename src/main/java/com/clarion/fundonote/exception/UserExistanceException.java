package com.clarion.fundonote.exception;

public class UserExistanceException extends RuntimeException
{
	private static final long serialVersionUID = 4371065778513954005L;
	private Integer statusCode;
	private String  description;
	
	public UserExistanceException(Integer statusCode,String description)
	{
		this.statusCode=statusCode;
		this.description=description;
	}
	public UserExistanceException(String property) {
		this.description=property;
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
