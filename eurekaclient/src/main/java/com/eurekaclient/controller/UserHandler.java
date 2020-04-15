package com.eurekaclient.controller;

import com.eurekaclient.entity.User;
import com.eurekaclient.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserHandler {
	@Autowired
	private UserRepository userRepository;

	@Value("${server.port}")
	private String port;


	@GetMapping("/findAll")
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/findById/{id}")
	public User findById(@PathVariable("id") long id) {
		return userRepository.findById(id);
	}

	@PostMapping("/save")
	public void save(@RequestBody User user) {
		userRepository.saveOrUpdate(user);
	}

	@PutMapping("/update")
	public void update(@RequestBody User user) {
		userRepository.saveOrUpdate(user);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id) {
		userRepository.deleteById(id);
	}

	@GetMapping("/index")
	public String index() {
		return "Portnumber:" + this.port;
	}
}