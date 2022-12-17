package com.book.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.demo.entity.Publisher;

@Repository
public interface IPublisherCustomRepository {

	public List<Publisher> getAllPublishersByCountry(String country) throws Exception;

	public Publisher getPublisherByPublisherName(String publisherName) throws Exception;

	public Publisher getPublisherByPublisherId(int publisherId) throws Exception;

	public Publisher getPublisherByAddress(String Address) throws Exception;

	@Query("from Publisher where publisherId >= :range1 and publisherId <= :range2")
	public List<Publisher> getPublishersBetweenIds(@Param("range1") int range1, @Param("range2") int range2)
			throws Exception;

}
