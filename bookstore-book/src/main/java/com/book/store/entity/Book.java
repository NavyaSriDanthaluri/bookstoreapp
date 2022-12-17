package com.book.store.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int isbNumber;
	@NotNull(message="Book title should not be null")
	private String title;
	private String authorName;
	private String category;
	private int price;
	private int avgerageRating;
	
	
	public Book(String title, String authorName, String category, int price, int avgerageRating) {
		super();
		this.title = title;
		this.authorName = authorName;
		this.category = category;
		this.price = price;
		this.avgerageRating = avgerageRating;
	}
	
}
