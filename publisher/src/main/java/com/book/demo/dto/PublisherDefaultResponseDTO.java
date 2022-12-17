package com.book.demo.dto;

public class PublisherDefaultResponseDTO implements MyDTO {
	private  String publisherName;
	private  String address;
	private  String country;
	
	

	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
   PublisherDefaultResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
   public PublisherDefaultResponseDTO(String publisherName, String address, String country) {
		super();
		this.publisherName = publisherName;
		this.address = address;
		this.country = country;
	}
   
}
