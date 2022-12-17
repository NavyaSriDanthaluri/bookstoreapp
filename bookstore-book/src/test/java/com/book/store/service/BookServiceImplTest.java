package com.book.store.service;

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

import com.book.store.entity.Book;
import com.book.store.repository.BookRepository;

@SpringBootTest
class BookServiceImplTest {

	@Mock
	BookRepository bookRepository;

	@InjectMocks
	BookServiceImpl bookService;

	@Test
	@DisplayName("Test to verify all books returned")
	//@Disabled
	void testGetAllBooks() throws Exception{
		
		// given
		Book book1 = new Book("devil", "birbal", "horror", 220, 4);
		
		Book book2 = new Book("crazy laughs", "akbar", "comic", 250, 4);
		
		List<Book> sampleOutput = new ArrayList<>();
		sampleOutput.add(book1);
		sampleOutput.add(book2);
		
		BDDMockito.given(bookService.getAllBooks()).willReturn(sampleOutput);
		
		// when :- ready to test the functionality (service)
		List<Book> actualOutput = bookService.getAllBooks();
		
		//verify
		assertNotNull(actualOutput);
		assertThat(actualOutput.size()).isGreaterThan(0);
		assertIterableEquals(sampleOutput, actualOutput);
		
	}

	@Test
	@DisplayName("Test - to verify the insert operation")
	// @Disabled
	void testInsertBook() throws Exception {

		// given
		Book sampleInput = new Book("devil", "birbal", "horror", 220, 4);
		Book expectedOutput = new Book("devil", "birbal", "horror", 220, 4);

		BDDMockito.given(bookService.insertBook(sampleInput)).willReturn(expectedOutput);

		// when
		Book actualOutput = bookService.insertBook(sampleInput);

		// verify
		assertEquals(expectedOutput, actualOutput);

	}

	@Test
	@Disabled
	void testGetBooksByCategory() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("Test to verify the method getById should return Book or not")
	@Disabled
	void testGetById() throws Exception {

		// give
		Book sampleOutput = new Book("devil", "birbal", "horror", 220, 4);
		sampleOutput.setIsbNumber(1);

		int sampleInput = 1;

		BDDMockito.given(bookService.getById(sampleInput)).willReturn(sampleOutput);

		// when
		Book actualOutput = bookService.getById(sampleInput);

		// verify
		assertEquals(sampleOutput, actualOutput);
		assertSame(sampleOutput.getIsbNumber(), actualOutput.getIsbNumber());
		assertThat(actualOutput.getIsbNumber()).isGreaterThan(0);
	}

	@Test
	@DisplayName(" Test to check books between price")
	//@Disabled
	void testGetBooksBetweenPrice() throws Exception {
		
		Book book1 = new Book("devil", "birbal", "horror", 220, 4);
		Book book2 = new Book("crazy laughs", "akbar", "comic", 250, 4);
		
		List<Book> sampleOutput = new ArrayList<>();
		sampleOutput.add(book1);
		sampleOutput.add(book2);
		
		int sampleInput1 = 200;
		int sampleInput2 = 250;
		
		
		BDDMockito.given(bookService.getBooksBetweenPrice(sampleInput1, sampleInput2))
		          .willReturn(sampleOutput);
		
		
		// when 
		
		List<Book> actualOutput = bookService.getBooksBetweenPrice(sampleInput1, sampleInput2);
		
		
		// verify 
		assertEquals(sampleOutput, actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
		assertNotNull(actualOutput);
	
	}

	@Test
	@Disabled
	void testGetBooksBetweenRating() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testUpdateBook() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetBooksByAuthorName() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testSortBooksByRating() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testSortBooksByTitle() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testSortBooksByPrice() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testSortBooksByAuthorName() {
		fail("Not yet implemented");
	}

}
