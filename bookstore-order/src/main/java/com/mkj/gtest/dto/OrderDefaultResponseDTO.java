package com.mkj.gtest.dto;

import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component

public class OrderDefaultResponseDTO  implements MyDTO{
	private String userName;
	private String bookName;
	private String orderDate;

}	


