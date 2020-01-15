package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Books;
import com.app.pojos.Copies;
import com.app.pojos.Users;
import com.app.service.ILibrarianService;
import com.app.service.IUserService;
import com.app.service.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/librarian")
public class LibrarianController 
{
	@Autowired 
	private ILibrarianService service;
	@Autowired
	private IUserService Uservice;
	
	@PostConstruct
	public void myInit() {
		System.out.println("in init " + service);
	}
	
	@PostMapping("/member")
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
	
	@PostMapping("/book")
	public ResponseEntity<?> addBookDetails(@RequestBody Books b)
	{
		System.out.println("in add book dtls" + b);
		try
		{
			return new ResponseEntity<Books>(service.addBookDetails(b),HttpStatus.CREATED);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/{bookid}")
	public ResponseEntity<?> addCopyDetails(@PathVariable int bookid,@RequestBody Copies c)
	{
		System.out.println("in add copies dtls" + c);
		System.out.println("bookid"+bookid);
		try
		{
			Books b = new Books();
			b.setId(bookid);
			b.addCopies(c);
			c.setStatus("available");
			return new ResponseEntity<Copies>(service.addCopyDetails(c),HttpStatus.CREATED);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	  @PutMapping("/update") 
	  public ResponseEntity<?> editProfile(@RequestBody Users u) 
	  {
		  System.out.println("in edit profile "+ u);
		  try
		  {
			  return new ResponseEntity<Users>(service.editProfile(u), HttpStatus.OK);
		  }catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  
	  }
	 @GetMapping("/list")
	 public ResponseEntity<?> getAllUsers()
	 {
		 System.out.println("in get all users");
		 List<Users> userList = service.listAllUsers();
		 if(userList.size() == 0)
			 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		 return new ResponseEntity<List<Users>>(userList, HttpStatus.OK);
	 }
	 
	
}