package asif.rest.api.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import asif.rest.api.data.User;
import asif.rest.api.exception.UserNotFoundException;
import asif.rest.api.service.UserDaoService;

@RestController
public class UserController {
	
	UserDaoService userService;
	
	
	public UserController(UserDaoService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<String> saveUser(@RequestBody User user) throws URISyntaxException{
		userService.saveUser(user);
		URI location = new URI("/user/3");
		return new ResponseEntity<String>("User created ", HttpStatusCode.valueOf(201));
		
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) throws UserNotFoundException{
		
		User user =userService.getUserById(id);
		if(user==null) {
			throw new UserNotFoundException("User is not present");
		}
			
		
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		
	}
}
