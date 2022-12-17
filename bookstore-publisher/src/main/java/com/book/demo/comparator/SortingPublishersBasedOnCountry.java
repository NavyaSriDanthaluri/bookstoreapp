package com.book.demo.comparator;

import java.util.Comparator;
import com.book.demo.entity.Publisher;

public class SortingPublishersBasedOnCountry implements Comparator<Publisher> {

	@Override
	public int compare(Publisher o1, Publisher o2) {

		return o2.getCountry().compareTo(o1.getCountry());
	}

}
