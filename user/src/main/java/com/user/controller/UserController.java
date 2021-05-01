package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.user.exception.ResourceNotFoundException;
import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.service.SequenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	private SequenceService service;
	
	/*@PostMapping("/adduser")
    public ResponseEntity<?> signUp(@RequestBody User user) {

        repository.save(user);
        
        user.setId(service.getSequenceNumber(SEQUENCE_NAME));
        return ResponseEntity.ok("Added User to the Database with id: " + user.getId());

    }*/
	
	/*public String saveUser(@RequestBody User user) {
		repository.save(user);
		return "Added flight with id : " + user.getId() ;
		
	}*/
	
	@PostMapping("/adduser")
	public User save(@RequestBody User user){
		//generate sequence
		user.setId(service.getSequenceNumber(User.SEQUENCE_NAME));
		return repository.save(user);
	}

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    /*@GetMapping("/allUsers/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return repository.findById(id);
    }
    
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User UserDetails) {
    	User user = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("bookingDetails does not exist with id:" + id));
    			
    	
    	user.setUserName(UserDetails.getUserName());
    	user.setFirstName(UserDetails.getFirstName());
    	user.setLastName(UserDetails.getLastName());
    	user.setPassword(UserDetails.getPassword());
    	user.setEmail(UserDetails.getEmail());
    	user.setRoles(UserDetails.getRoles());
    	user.setActive(UserDetails.getActive());
    	
    	User updatedUser = repository.save(user);
    	return ResponseEntity.ok(updatedUser);
    	
    	
    }*/
    
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) throws Exception {
        repository.deleteById(id);
        return ResponseEntity.ok("deleted User to the Database with id: " + id);
    }


}
