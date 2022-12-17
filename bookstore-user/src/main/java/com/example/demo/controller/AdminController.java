package com.example.demo.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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

import com.example.demo.dto.ErrorDTO;
import com.example.demo.dto.MyDTO;
import com.example.demo.dto.UserDefaultResponseDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import com.example.demo.util.UserDTOCovertor;

@RestController
@RequestMapping("/admin")

public class AdminController {
	@Autowired
	UserService userService;
	

	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/add")
	public ResponseEntity<String> addUsers(@RequestBody User user) // admin/add
	{

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

	@GetMapping("/users") // admin/users
	public List<User> getAllUsers() {
		try {
			List<User> allExtractedUsers = userService.getAllUser();
			return allExtractedUsers;
		} catch (Exception e) {
			System.out.println(e);
			mylogs.info("an Exception is occured");
		}
		return null;

	}

	@DeleteMapping("/userid/{searchUserId}") // admin//userid/6
	public ResponseEntity<String> deleteUser(@PathVariable int searchUserId) {
		try {
			String deletedUser = userService.delete(searchUserId);
			String responseMsg = "deleted the user";
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact to the customer care\n" + e;
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/user/{userId}") // admin/user/3
	public ResponseEntity<String> updateUser(@PathVariable int userId, @RequestBody User userDetails) throws Exception {
		userService.getUserByUserId(userId);
		userDetails.setUserId(userId);
		User updateUser = userService.addUser(userDetails);
		String msg = "user is updated";
		return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("username/{searchUserName}") // admin/username?userName=""
	public User getUserByUserName(@PathVariable String searchUserName) throws Exception {
		mylogs.info("getting the user by username");
		return userService.getUserByUserName(searchUserName);

	}

	@GetMapping("userid/{searchUserId}") // admin/userid?userId=""
	public User getUserByUserID(@PathVariable int searchUserId) throws Exception {
		mylogs.info("Getting the user by the userId");
		return userService.getUserByUserId(searchUserId);
	}

	@GetMapping("userrole/{searchUserRole}") // admin/userrole?userRole=""
	public User getUserByUserRole(@PathVariable String searchUserRole) throws Exception {
		mylogs.info("Getting the user on the basis of role");
		return userService.getUserByRole(searchUserRole);
	}

	@GetMapping("/usersbyId") // admin/usersbyId?r1=8&r2=9

	public List<User> usersById(@RequestParam int r1, @RequestParam int r2) throws Exception {
		mylogs.info("ids are fitered");

		return userService.getUsersBetweenIds(r1, r2);
	}

	@GetMapping("/sort/username")
	public List<User> sortingByUserName() throws Exception {
		return userService.sortUserByUserName();
	}

}
