package com.book.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO implements MyDTO {
	

	private int isbNumber;
	private String title;
	private int price;
	private String category;
}
