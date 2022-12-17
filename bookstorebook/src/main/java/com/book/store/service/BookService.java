package com.book.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.book.store.entity.Book;

@Service
public interface BookService {
	
	public Book insertBook(Book book) throws Exception;
	public Book getById(int isbNumber) throws Exception;
	public Book updateBook(Book book) throws Exception;
	public List<Book> getAllBooks() throws Exception;
	public List<Book> getBooksByCategory(String category) throws Exception;
	public List<Book> getBooksByAuthorName(String authorName) throws Exception;
	public List<Book> getBooksBetweenPrice(int range1,int range2)throws Exception;
	public List<Book> getBooksBetweenRating(int rate1,int rate2)throws Exception;
	public String delete(int isbNumber) throws Exception;
	
	public List<Book> sortBooksByRating() throws Exception;
	public List<Book> sortBooksByTitle() throws Exception;
	public List<Book> sortBooksByPrice() throws Exception;
	public List<Book> sortBooksByAuthorName() throws Exception;
	

} 
