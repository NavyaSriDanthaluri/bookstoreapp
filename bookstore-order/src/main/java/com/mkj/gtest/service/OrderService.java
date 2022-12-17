package com.mkj.gtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkj.gtest.entity.Order;

@Service



public interface OrderService {
	
	public Order insertOrder(Order order) throws Exception;
	
	public List<Order> getAllOrders() throws Exception;
	public Order updateOrderById(int orderId) throws Exception;
	public Order deleteOrderById(int orderId) throws Exception;
	public void delete(int orderId) throws Exception;



}