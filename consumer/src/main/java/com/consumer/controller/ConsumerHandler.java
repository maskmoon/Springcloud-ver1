package com.consumer.controller;

import com.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Collection;

@RestController
@RequestMapping("/consumer")
public class ConsumerHandler {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/findAll")
	public Collection<User> findAll() {
		return restTemplate.getForEntity("http://localhost:8010/user/findAll", Collection.class).getBody();
	}

	@GetMapping("/findAll2")
	public Collection<User> findAll2() {
		return restTemplate.getForObject("http://localhost:8010/user/findAll", Collection.class);
	}

	@GetMapping("/findById/{id}")
	public User findById(@PathVariable("id") long id) {
		return restTemplate.getForEntity("http://localhost:8010/user/findById/{id}", User.class, id).getBody();
	}

	@GetMapping("/findById2/{id}")
	public User findById2(@PathVariable("id") long id) {
		return restTemplate.getForObject("http://localhost:8010/user/findById/{id}", User.class, id);
	}

	@PostMapping("/save")
	public void save(@RequestBody User user) {

		restTemplate.postForEntity("http://localhost:8010/user/save", user, null).getBody();
	}

	@PostMapping("/save2")

	public void save2(@RequestBody User user) {

		restTemplate.postForObject("http://localhost:8010/user/save", user, null);
	}

	@PutMapping("/update")
	public void update(@RequestBody User user) {
		restTemplate.put("http://localhost:8010/user/update", user);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id) {

		restTemplate.delete("http://localhost:8010/user/deleteById/{id}", id);
	}
}