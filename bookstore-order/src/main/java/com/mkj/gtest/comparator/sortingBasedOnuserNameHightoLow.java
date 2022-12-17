package com.mkj.gtest.comparator;

import java.util.Comparator;

import com.mkj.gtest.entity.Order;

public class sortingBasedOnuserNameHightoLow implements Comparator<Order> {

	

	

	@Override
	public int compare(Order o1, Order o2) {
		// TODO Auto-generated method stub
		return o2.getUserName().compareTo(o1.getUserName());
	}
}