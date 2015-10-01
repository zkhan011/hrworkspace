package com.es.example.hr.service;


public class InvalidSalaryException extends Exception {

	
	private String msg;
	
	public InvalidSalaryException(){}
	
	public InvalidSalaryException(String msg){
		super(msg);
		this.msg=msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
