package com.ribbon.controller;

import com.ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonHandler {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/findAll")
	public Collection<User> findAll() {
		return restTemplate.getForObject("http://provider/user/findAll", Collection.class);
	}

	@GetMapping("/index")
	public String index() {
		return restTemplate.getForObject("http://provider/user/index", String.class);
	}
}