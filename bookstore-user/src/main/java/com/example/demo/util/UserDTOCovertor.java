package com.example.demo.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDefaultResponseDTO;
import com.example.demo.dto.UserPostCreatedResponseDTO;
import com.example.demo.entity.User;
@Component
@Scope("singleton")
public class UserDTOCovertor {

	
	public static UserDefaultResponseDTO  getUserDefaultDTO(User user)
	{
		UserDefaultResponseDTO dto = new UserDefaultResponseDTO(
				                 user.getUserName(), 
				                 
				                 user.getRole(),
				                 user.getPassword()); 
				                
		return dto;
	}
	
	
	
	
	public static UserPostCreatedResponseDTO getPostCreatedDTO(User user)
	{
		UserPostCreatedResponseDTO dto = new UserPostCreatedResponseDTO(
				 user.getUserName(), 
                 user.getRole(),
                 user.getPassword());
               	 return dto;
	}

}
