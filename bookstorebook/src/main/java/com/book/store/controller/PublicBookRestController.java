package com.book.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.entity.Book;
import com.book.store.service.BookService;
import com.book.store.util.BookDTOConverter;

@RestController
@RequestMapping("/public/bookstore")
public class PublicBookRestController {

	@Autowired
	BookService bookService;

	@Autowired
	BookDTOConverter dtoConverter;

	public PublicBookRestController() {
		System.out.println("\n\n\n=======>> Inside Constructor " + this);
	}

	@GetMapping("/welcome")
	public String welcome() {

		return "Welcome to Book Store";

	}

	// localhost:8001/public/bookstore/books
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		try {
			List<Book> allExtractedBooks = bookService.getAllBooks();
			return allExtractedBooks;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// localhost:8001/public/bookstore/isbNumber/1
	@GetMapping("/isbnumber/{isbNumber}")
	public Book getBookByISBNumber(@PathVariable int isbNumber) throws Exception {

		return bookService.getById(isbNumber);

	}

	// localhost:8001/public/bookstore/category/comic
	@GetMapping("/category/{category}")
	public List<Book> getBookByCategory(@PathVariable String category) throws Exception {

		return bookService.getBooksByCategory(category);

	}

	// localhost:8001/public/bookstore/author/akbar
	@GetMapping("/author/{authorName}")
	public List<Book> getBooksByAuthorName(@PathVariable String authorName) throws Exception {

		return bookService.getBooksByAuthorName(authorName);

	}

	// localhost:8001/public/bookstore/booksbyprice?r1=200&r2=300
	@GetMapping("/booksbyprice")
	public List<Book> booksById(@RequestParam int r1, @RequestParam int r2) throws Exception {

		return bookService.getBooksBetweenPrice(r1, r2);
	}

	// localhost:8001/public/bookstore/booksbyrating?r1=3&r2=5
	@GetMapping("/booksbyrating")
	public List<Book> booksByRating(@RequestParam int r1, @RequestParam int r2) throws Exception {

		return bookService.getBooksBetweenRating(r1, r2);
	}

}
