package com.mkj.gtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mkj.gtest.entity.Order;

@Repository

public interface IOrderCustomRepository {
	
	public Order  getOrderByUserName(String userName) throws Exception;
	public Order getOrderByBookName(String bookName) throws Exception;
	public Order getOrderByOrderId(int orderId) throws Exception;
}