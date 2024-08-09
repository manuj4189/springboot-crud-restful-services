package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//get all users 
	@GetMapping
	public List<User> getAllUsers(){
		return userRepository.findAll();
		
	}
	
	//get user by id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value="id") long userId)
	{
		//throw exception if user not exists in database
		return this.userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with id:" +userId));
	}
	
	@GetMapping("/greet")
	public String greetMsg(){
		string msg="welcome to ashok it";
		String int="Ashok it"
		return msg;
	}
	@GetMapping("/greeting")
	public String greetingMsg(){
		string msg="welcome";
		return msg;
	}
@GetMapping("/register2")
	public String greetingMsg(){
		string msg="registration";
		return msg;
	}

	

	@GetMapping("/login")
	public String loginMsg(){
		string msg="login my account";
		return msg;

    @GetMapping("/register")
	public String registerMsg(){
		string msg="register in my account";
		return msg;

	@GetMapping("/welcome")
	public String greetingMsg(){
		string msg="welcome";
		return msg;
	}


	
	@PostMapping
	public User createUser(@RequestBody User user) {
		
		return this.userRepository.save(user);
	}
	

	//update user
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") long userId)
	
	{
		User existinguser=userRepository.findById(userId)
		.orElseThrow(()-> new ResourceNotFoundException("User not found with id:" +userId));
         existinguser.setFirstname(user.getFirstname());
         existinguser.setLastName(user.getLastName());
         existinguser.setEmail(user.getEmail());
		return this.userRepository.save(existinguser);
	}
	
	//deelte user
	@DeleteMapping("{id}")
	public ResponseEntity<User> detleteUser(@PathVariable("id") long userId){
		
		User existinguser=userRepository.findById(userId)
		.orElseThrow(()-> new ResourceNotFoundException("User not found with id:" + userId));

		 this.userRepository.delete(existinguser);
		 return ResponseEntity.ok().build();
		
	}
	

}
