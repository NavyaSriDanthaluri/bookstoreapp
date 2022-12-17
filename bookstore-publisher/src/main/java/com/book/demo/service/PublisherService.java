package com.book.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.book.demo.entity.Publisher;

@Service
public interface PublisherService {

	public Publisher addPublisher(Publisher publisher) throws Exception;

	public List<Publisher> getAllPublishers() throws Exception;

	public Publisher updatePublisher(Publisher publisher) throws Exception;

	public void deletePublisherById(int publisherId);

	public Publisher getPublisherByPublisherId(int publisherId) throws Exception;

	public List<Publisher> getPublishersBetweenIds(int range1, int range2) throws Exception;

	public List<Publisher> filterByPublisherName(String publisherName) throws Exception;

	public List<Publisher> filterByAddress(String adddress) throws Exception;

	public List<Publisher> filterByCountry(String country) throws Exception;

	public List<Publisher> SortingPublishersBasedOnCountry() throws Exception;

}
