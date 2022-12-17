package com.book.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int publisherId;
	@NotNull(message = "publishername should not be null")
	private String publisherName;
	@NotNull(message = "address should not be null")
	private String address;
	private String country;

	public Publisher() {
		super();

	}

	public Publisher(@NotNull(message = "publishername should not be null") String publisherName,
			@NotNull(message = "address should not be null") String address, String country) {
		super();
		this.publisherName = publisherName;
		this.address = address;
		this.country = country;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

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

	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", address=" + address
				+ ", country=" + country + "]";
	}

}
