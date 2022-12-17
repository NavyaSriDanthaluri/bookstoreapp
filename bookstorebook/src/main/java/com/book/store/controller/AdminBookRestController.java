package com.book.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.dto.BookResponseDTO;
import com.book.store.dto.DefaultResponseDTO;
import com.book.store.dto.ErrorDTO;
import com.book.store.dto.MyDTO;
import com.book.store.entity.Book;
import com.book.store.repository.BookRepository;
import com.book.store.service.BookService;
import com.book.store.util.BookDTOConverter;

@RestController
@RequestMapping("/admin/bookstore")
@Validated
public class AdminBookRestController {

	@Autowired
	BookService bookService;

	@Autowired
	BookDTOConverter dtoConverter;

	private final Logger mylogs = LoggerFactory.getLogger(getClass());

	public AdminBookRestController() {
		System.out.println("\n\n\n=======>> Inside Constructor " + this);
	}

	// localhost:8001/admin/bookstore/addbook
	@PostMapping("/addbook")
	public ResponseEntity<MyDTO> addBook(@RequestBody @Valid Book book) {
		try {
			Book savedBook = bookService.insertBook(book);
			// String responseMsg = savedBook.getTitle()+ " save with ISBNumber
			// "+savedBook.getIsbNumber();
			// mylogs.info("Book added successfully....");
			BookResponseDTO dto = BookDTOConverter.convertToDTO(savedBook);
			return new ResponseEntity<MyDTO>(dto, HttpStatus.OK);
		} catch (Exception e) {

			// String errorMsg = "Contact customer care Ph.no:- 1800-250-900 or mail to:-
			// bookstore@gmail.com \n" +e;
			ErrorDTO errorDTO = new ErrorDTO(e.getMessage());
			return new ResponseEntity<MyDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// localhost:8001/admin/bookstore/delete/1
	@DeleteMapping("/delete/{isbNumber}")
	/*
	 * public String deleteBook(@PathVariable int isbNumber) { try {
	 * bookService.delete(isbNumber); } catch (Exception e) { e.printStackTrace(); }
	 * return "book deleted"; }
	 */
	public ResponseEntity<String> deleteBook(@PathVariable int isbNumber) {
		try {
			String deletedBook = bookService.delete(isbNumber);
			String responseMsg = "deleted the book selected";
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact concerned manager \n" + e;
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//// localhost:8001/admin/bookstore/update
	@PutMapping("/update")
	public Book updateBook(@RequestBody Book bookDetails) throws Exception {

		return bookService.updateBook(bookDetails);
	}
}
