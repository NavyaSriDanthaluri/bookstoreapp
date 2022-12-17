package com.book.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.entity.Book;
import com.book.store.service.BookService;

@RestController
@RequestMapping("/user/bookstore")
public class UserBookRestController {

	@Autowired
	BookService bookService;

	public UserBookRestController() {
		System.out.println("\n\n\n=======>> Inside Constructor " + this);
	}

	// localhost:8001/user/bookstore/sort/rating
	@GetMapping("/sort/rating")
	public List<Book> sortingByRating() throws Exception {

		return bookService.sortBooksByRating();

	}

	// localhost:8001/user/bookstore/sort/title
	@GetMapping("/sort/title")
	public List<Book> sortingByTitle() throws Exception {

		return bookService.sortBooksByTitle();

	}

	// localhost:8001/user/bookstore/sort/price
	@GetMapping("/sort/price")
	public List<Book> sortingByPrice() throws Exception {

		return bookService.sortBooksByPrice();

	}

	// localhost:8001/user/bookstore/sort/author
	@GetMapping("/sort/author")
	public List<Book> sortingByAuthorName() throws Exception {

		return bookService.sortBooksByAuthorName();

	}

}
