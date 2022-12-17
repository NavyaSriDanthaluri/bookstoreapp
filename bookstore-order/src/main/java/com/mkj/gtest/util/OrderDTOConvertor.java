package com.mkj.gtest.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mkj.gtest.dto.OrderDefaultResponseDTO;
import com.mkj.gtest.entity.Order;

@Component
@Scope("singleton")

public class OrderDTOConvertor {

	public static OrderDefaultResponseDTO  getOrderDefaultDTO(Order order)
	{
		OrderDefaultResponseDTO dto = new OrderDefaultResponseDTO(
			order.getBookName(),
			order.getUserName(),
			order.getOrderDate());
		return dto;
			
			
 
                
	}


		public static OrderDefaultResponseDTO convertToDTO(Order savedOrder) {
			// TODO Auto-generated method stub
			return null;
		}

		
	}


