package com.book.store.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.comparator.SortBooksByRatingHighToLow;
import com.book.store.comparator.SortBooksByTitle;
import com.book.store.comparator.SortByAuthorName;
import com.book.store.comparator.SortByPriceHighToLow;
import com.book.store.entity.Book;
import com.book.store.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() throws Exception {

		List<Book> allBooks = bookRepository.findAll();
		return allBooks;
	}

	@Override
	public Book insertBook(Book book) throws Exception {
		Book savedBook = bookRepository.save(book);
		if (savedBook != null) {
			return savedBook;
		} else {
			return null;
		}

	}

	@Override
	public List<Book> getBooksByCategory(String category) throws Exception {

		return bookRepository.getBooksByCategory(category);
	}

	@Override
	public Book getById(int isbNumber) throws Exception {

		return bookRepository.findById(isbNumber).get();
	}

	@Override
	public List<Book> getBooksBetweenPrice(int range1, int range2) throws Exception {

		return bookRepository.getBooksBetweenPrice(range1, range2);
	}

	@Override
	public List<Book> getBooksBetweenRating(int rate1, int rate2) throws Exception {

		return bookRepository.getBooksBetweenRating(rate1, rate2);
	}

	@Override
	public String delete(int isbNumber) throws Exception {

		bookRepository.deleteById(isbNumber);
		return "Book deleted";

	}

	@Override
	public Book updateBook(Book book) throws Exception {

		Book savedBook = bookRepository.save(book);

		return savedBook;
	}

	@Override
	public List<Book> getBooksByAuthorName(String authorName) throws Exception {

		return bookRepository.getBooksByAuthorName(authorName);
	}

	@Override
	public List<Book> sortBooksByRating() throws Exception {
		List<Book> list = bookRepository.findAll();
		List<Book> book = new ArrayList<>();
		Collections.sort(list, new SortBooksByRatingHighToLow());
		return list;
	}

	@Override
	public List<Book> sortBooksByTitle() throws Exception {
		List<Book> list = bookRepository.findAll();
		List<Book> book = new ArrayList<>();
		Collections.sort(list, new SortBooksByTitle());
		return list;
	}

	@Override
	public List<Book> sortBooksByPrice() throws Exception {
		List<Book> list = bookRepository.findAll();
		List<Book> book = new ArrayList<>();
		Collections.sort(list, new SortByPriceHighToLow());
		return list;
	}

	@Override
	public List<Book> sortBooksByAuthorName() throws Exception {
		List<Book> list = bookRepository.findAll();
		List<Book> book = new ArrayList<>();
		Collections.sort(list, new SortByAuthorName());
		return list;
	}
}
