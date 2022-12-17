package com.book.store.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DefaultResponseDTO {

	private String title;
	private int price;
	private String authorName;
	private String remarks;
}
