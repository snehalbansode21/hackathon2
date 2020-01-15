package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Users;
import com.app.service.ILibrarianService;

@RestController
@RequestMapping("/librarian")
public class LibrarianController 
{
	@Autowired 
	private ILibrarianService service;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}
	
	@PostMapping
	public ResponseEntity<?> addMemberDetails(@RequestBody Users u)
	{
		System.out.println("in add user dtls" + u);
		try
		{
			return new ResponseEntity<Users>(service.addMemberDetails(u),HttpStatus.CREATED);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/*
	 * @PutMapping("/update") public ResponseEntity<?> editProfile(@RequestBody
	 * Users u,) {
	 * 
	 * }
	 */
	
}