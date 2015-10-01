package com.es.example.hr.dao;

public class DAOException extends RuntimeException {
	
	private String msg;
	
	public DAOException(){
		
	}
	
	public DAOException(String msg){
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
