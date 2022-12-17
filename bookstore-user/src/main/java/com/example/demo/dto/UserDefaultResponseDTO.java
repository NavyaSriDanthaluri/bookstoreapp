package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class UserDefaultResponseDTO  implements MyDTO{
		private String userName;
	    private String password;
	    private String role;
		public UserDefaultResponseDTO(String userName, String password, String role) {
			super();
			this.userName = userName;
			this.password = password;
			this.role = role;
		}
		
	
	
}
