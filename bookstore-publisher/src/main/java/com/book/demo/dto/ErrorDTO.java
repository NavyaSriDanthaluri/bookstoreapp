package com.book.demo.dto;

public class ErrorDTO implements MyDTO {

	private  String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	
	ErrorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
