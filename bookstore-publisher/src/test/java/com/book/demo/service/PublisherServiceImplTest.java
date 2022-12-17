package com.book.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.demo.entity.Publisher;
import com.book.demo.repository.PublisherRepository;

@SpringBootTest
class PublisherServiceImplTest {

	@Mock
	PublisherRepository publisherRepository;

	@InjectMocks
	PublisherServiceImpl publisherService;

	@Test
	@DisplayName("Test - to verify the add operation")
	void testAddPublisher() throws Exception {
		// given
		Publisher sampleInput = new Publisher("westlands", "chennai", "india");
		Publisher expectedOutput = new Publisher("westlands", "chennai", "india");
		// Object obj = new Object();
		BDDMockito.given(publisherService.addPublisher(sampleInput)).willReturn(expectedOutput);

		// when
		Publisher actualOutput = publisherService.addPublisher(sampleInput);

		// verify
		assertEquals(expectedOutput, actualOutput);

	}

	@Test
	@DisplayName("Test to verify the method getPublisher by publisherId should return Publisher or not")
	void testGetPublisherByPublisherId() throws Exception {

		Publisher sampleOutput = new Publisher("westlands", "chennai", "india");
		sampleOutput.setPublisherId(1);

		int sampleInput = 1;

		BDDMockito.given(publisherService.getPublisherByPublisherId(sampleInput)).willReturn(sampleOutput);

		// when
		Publisher actualOutput = publisherService.getPublisherByPublisherId(sampleInput);

		// verify
		assertEquals(sampleOutput, actualOutput);
		assertSame(sampleOutput.getPublisherId(), actualOutput.getPublisherId());
		assertThat(actualOutput.getPublisherId()).isGreaterThan(0);

	}

	// @Disabled
	@Test
	@DisplayName(" Test to check users between Id")
	void testGetPublishersBetweenIds() throws Exception {

		// give

		Publisher publisher1 = new Publisher("westlands", "chennai", "india");

		Publisher publisher2 = new Publisher("Horper Collins", "New York", "United States");

		List<Publisher> sampleOutput = new ArrayList<>();

		int sampleInput1 = 1;
		int sampleInput2 = 20;

		BDDMockito.given(publisherService.getPublishersBetweenIds(sampleInput1, sampleInput2)).willReturn(sampleOutput);

		// when

		List<Publisher> actualOutput = publisherService.getPublishersBetweenIds(sampleInput1, sampleInput2);

		// verify
		assertEquals(sampleOutput, actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
		assertNotNull(actualOutput);

	}

}
