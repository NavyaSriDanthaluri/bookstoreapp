package com.book.demo.exception;

public class AllExceptionDTO {

	
	private  String msg;
	private  String publisherInput;
	private  String dateAndTime;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getPublisherInput() {
		return publisherInput;
	}
	public void setPublisherInput(String publisherInput) {
		this.publisherInput = publisherInput;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	
	AllExceptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	AllExceptionDTO(String msg, String publisherInput, String dateAndTime) {
		super();
		this.msg = msg;
		this.publisherInput = publisherInput;
		this.dateAndTime = dateAndTime;
	}
}
