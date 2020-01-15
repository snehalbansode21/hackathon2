package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Users;
import com.app.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}
	
	@GetMapping("/login")
	public String showLoginForm()
	{
		System.out.println("in show login form");
		return "/user/login";
	}
	@PostMapping("/login")
	public ResponseEntity<?> processForm(@RequestBody Users u)
	{
		System.out.println("in process form "+ u);
		String em = u.getEmail();
		String pass = u.getPassword();
		//u.setEmail(em);
		//u.setPassword(pass);
		
		System.out.println("em and pass" + em +" "+pass);
		Users user = service.userAuthenticate(em, pass);
		return new ResponseEntity<Users>(user,HttpStatus.OK);
		//user.getPaymentList().size();
	//	System.out.println("user" +user);
//		try
//		{
//			if(user != null)
//			{
//				return new ResponseEntity<Users>(user,HttpStatus.OK);
//			}
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//		}catch (RuntimeException e) {
//			e.printStackTrace();
//			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
}
