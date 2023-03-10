package com.book.store.comparator;

import java.util.Comparator;

import com.book.store.entity.Book;

public class SortBooksByTitle implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {

		return o1.getTitle().compareTo(o2.getTitle());
	}

}
