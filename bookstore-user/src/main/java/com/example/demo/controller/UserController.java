package com.example.demo.controller;

import java.util.List;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MyDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody User user) {

		try {
			User savedUser = userService.addUser(user);
			String responseMsg = savedUser.getUserName() + " save with Id " + savedUser.getUserId();
			mylogs.info("A value is added ");
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/userid/{searchUserId}")
	public ResponseEntity<MyDTO> deleteUser(@PathVariable int searchUserId) {
		try {
			userService.delete(searchUserId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		mylogs.info(" user is deleted");

		return new ResponseEntity<MyDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/userid/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody User userDetails) throws Exception {
		userService.getUserByUserId(userId);
		userDetails.setUserId(userId);
		User updateUser = userService.addUser(userDetails);

		return updateUser;

	}

}
