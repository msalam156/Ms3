package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.dto.LoginDTO;
import com.nissan.dto.SignUpDTO;
import com.nissan.model.UserRegister;
import com.nissan.model.UserType;
import com.nissan.service.IUserService;


@CrossOrigin		//Helps to Avoid CORS Error
@RestController
@RequestMapping("api/")
public class UserRestController
{
	//Field Injection
	@Autowired
	IUserService userService;
	
	
	//List All UserRegisters
	@GetMapping("userRegisters")
	public List<UserRegister> findAllUserRegister()
	{
		System.out.println("-----------Here in GET userRegisters----------");
		return userService.findAllUserRegister();
	}
	
	//List All UserType
	@GetMapping("userTypes")
	public List<UserType> findAllUserType()
	{
		return userService.findAllUserType();
	}
	
	
	//Find UserRegister By Username & Password
	@PostMapping("login")
	public UserRegister findUserByUsernamePassword(@RequestBody LoginDTO loginDTO)
	{
		return userService.findUserByUsernamePassword(loginDTO);
	}
	
	//Find UserRegister By UserID 
	@GetMapping("login/{userID}")
	public UserRegister findUserByUserID(@PathVariable int userID)
	{
		return userService.findUserByUserID(userID);
	}
	
//	//Add UserRegister
//	@PostMapping("userRegister")
//	public UserRegister addUserRegister(@RequestBody SignUpDTO signUpDTO)
//	{
//		return userService.addUserRegister(signUpDTO);
//	}
	
	//Update UserRegister
	@PutMapping("userRegister/{userID}")
	public UserRegister updateUserRegister(@RequestBody SignUpDTO signUpDTO, @PathVariable int userID)
	{
		return userService.updateUserRegister(signUpDTO, userID);
	}
	
	//Disable User Login
	@DeleteMapping("login/{loginID}")
	public void disableLogin(@PathVariable int loginID)
	{
		userService.disableLogin(loginID);
	}
	
	//Enable User Login
	@PutMapping("login/{loginID}")
	public void enableLogin(@PathVariable int loginID)
	{
		userService.enableLogin(loginID);
	}
	
}






