package com.book.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.store.entity.Book;

@Repository
public interface IBookCustomRepository {
	
	public List<Book> getBooksByCategory(String category) throws Exception;
	public List<Book> getBooksByAuthorName(String authorName)throws Exception;
	
	@Query("from Book where averageRating >= :rate1 and averageRating <= :rate2")
	public List<Book> getBooksBetweenRating(@Param("rate1") int rate1,@Param("rate2") int rate2)throws Exception;
	
	@Query("from Book where price >= :range1 and price <= :range2")
	public List<Book> getBooksBetweenPrice(@Param("range1") int range1,@Param("range2") int range2)throws Exception;
	

}
