package com.mkj.gtest.repository;

import org.springframework.stereotype.Repository;

import com.mkj.gtest.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface OrderRepository extends JpaRepository<Order, Integer>  {

}

