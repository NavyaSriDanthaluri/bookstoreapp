package com.book.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.demo.comparator.SortingPublishersBasedOnCountry;
import com.book.demo.entity.Publisher;
import com.book.demo.repository.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	PublisherRepository publisherRepository;

	@Override
	public Publisher addPublisher(Publisher publisher) throws Exception {
		// TODO Auto-generated method stub

		Publisher savedPublisher = publisherRepository.save(publisher);
		return savedPublisher;

	}

	@Override
	public List<Publisher> getAllPublishers() throws Exception {
		// TODO Auto-generated method stub

		List<Publisher> allPublishers = publisherRepository.findAll();
		return allPublishers;

	}

	@Override
	public Publisher updatePublisher(Publisher publisher) throws Exception {

		Publisher existingPublisher = publisherRepository.findById(publisher.getPublisherId()).orElse(null);
		existingPublisher.setPublisherName(publisher.getPublisherName());
		existingPublisher.setAddress(publisher.getAddress());
		existingPublisher.setCountry(publisher.getCountry());
		return publisherRepository.save(existingPublisher);
	}

	@Override
	public void deletePublisherById(int publisherId) {

		publisherRepository.deleteById(publisherId);
	}

	@Override
	public Publisher getPublisherByPublisherId(int publisherId) throws Exception {
		Publisher publisher = publisherRepository.getPublisherByPublisherId(publisherId);
		return publisher;
	}

	@Override
	public List<Publisher> getPublishersBetweenIds(int range1, int range2) throws Exception {
		return publisherRepository.getPublishersBetweenIds(range1, range2);
	}

	@Override
	public List<Publisher> SortingPublishersBasedOnCountry() throws Exception {

		List<Publisher> list = publisherRepository.findAll();
		List<Publisher> allPublishers = new ArrayList<>();
		Collections.sort(list, new SortingPublishersBasedOnCountry());
		return list;

	}

	@Override
	public List<Publisher> filterByPublisherName(String publisherName) throws Exception {
		// TODO Auto-generated method stub
		List<Publisher> allfilteredPublisherNames = getAllPublishers().stream()
				.filter((publisher) -> publisher.getPublisherName().equals(publisherName)).collect(Collectors.toList());
		return allfilteredPublisherNames;
	}

	@Override
	public List<Publisher> filterByAddress(String adddress) throws Exception {
		// TODO Auto-generated method stub
		List<Publisher> allfilteredAddress = getAllPublishers().stream()
				.filter((publisher) -> publisher.getAddress().equals(adddress)).collect(Collectors.toList());
		return allfilteredAddress;
	}

	@Override
	public List<Publisher> filterByCountry(String country) throws Exception {
		List<Publisher> allfilteredCountry = getAllPublishers().stream()
				.filter((publisher) -> publisher.getCountry().equals(country)).collect(Collectors.toList());
		return allfilteredCountry;
	}

}
