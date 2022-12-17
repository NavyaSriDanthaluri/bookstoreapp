package com.mkj.gtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.gtest.entity.Order;
import com.mkj.gtest.repository.OrderRepository;

@Service


public class OrderServiceImpl  implements OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order insertOrder(Order order) throws Exception {
		Order savedOrder = orderRepository.save(order);
		if(savedOrder != null)
		{
			return savedOrder;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Order> getAllOrders() throws Exception {
		List<Order> allBooks = orderRepository.findAll();
		return allBooks;
	}

	@Override
	public Order updateOrderById(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deleteOrderById(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int orderId) throws Exception {
		orderRepository.deleteById(orderId);
		
		
	}
	

}
