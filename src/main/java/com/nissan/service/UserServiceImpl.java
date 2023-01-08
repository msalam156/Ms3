package com.nissan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.dto.LoginDTO;
import com.nissan.dto.SignUpDTO;
import com.nissan.model.Login;
import com.nissan.model.UserRegister;
import com.nissan.model.UserType;
import com.nissan.repo.ILoginRepo;
import com.nissan.repo.IUserRegisterRepo;
import com.nissan.repo.IUserTypeRepo;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService
{
	//Field Injection
	@Autowired
	IUserRegisterRepo userRegisterRepo;

	@Autowired
	ILoginRepo loginRepo;
	
	@Autowired
	IUserTypeRepo userTypeRepo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	
	//Find All UserRegister
	@Override
	public List<UserRegister> findAllUserRegister()
	{
		return  (List<UserRegister>)userRegisterRepo.findAll();
	}
	
	
	//Find All UserType
	@Override
	public List<UserType> findAllUserType()
	{
		return (List<UserType>)userTypeRepo.findAll();
	}
	
	

	//Find UserRegister by Username & Password
	@Override
	public UserRegister findUserByUsernamePassword(LoginDTO loginDTO)
	{
		UserRegister userRegister = userRegisterRepo.findByUsernamePassword(loginDTO.getUsername(),loginDTO.getPassword());
		
		System.out.println("logindto.username = " + loginDTO.getUsername());
		System.out.println("logindto.password = " + loginDTO.getPassword());
		//Check User Exist or not
		if(userRegister == null)
		{
			return null;
		}
		return userRegister;
	}
	
	//Find UserRegister by userID
	@Override
	public UserRegister findUserByUserID(int userID)
	{
		UserRegister userRegister = userRegisterRepo.findUserByUserID(userID);
		
		//Check User Exist or not
		if(userRegister == null)
		{
			return null;
		}
		
		return userRegister;
	}
	
	
	//Find By Username
	@Override
	public UserRegister findByUsername(String username)
	{
		UserRegister userRegister = userRegisterRepo.findByUsername(username);
		
		//Check User Exist or not
		if(userRegister == null)
		{
			return null;
		}
		
		return userRegister;
	}
	
	
	@Transactional
	@Override
	public UserRegister addUserRegister(SignUpDTO signUpDTO)
	{
		//Encrypting the Password
		signUpDTO.setPassword(bcryptEncoder.encode(signUpDTO.getPassword()));
		//Mapping from DTO to UserRegister
		Login login = new Login(signUpDTO);
		
		UserRegister userRegister = new UserRegister(signUpDTO, loginRepo.save(login));
		
		//Setting Active as True
		userRegister.getLogin().setActive(true);
		
		return userRegisterRepo.save(userRegister);
	}

	
	@Transactional
	@Override
	public UserRegister updateUserRegister(SignUpDTO signUpDTO, int userID)
	{

		UserRegister userRegister = userRegisterRepo.findUserByUserID(userID);
		userRegister.setFirstName(signUpDTO.getFirstName());
		userRegister.setLastName(signUpDTO.getLastName());
		userRegister.setAge(signUpDTO.getAge());
		userRegister.setGender(signUpDTO.getGender());
		userRegister.setAddress(signUpDTO.getAddress());
		userRegister.setPhoneNo(signUpDTO.getPhoneNo());
		userRegister.getLogin().setUsername(signUpDTO.getUsername());
		userRegister.getLogin().setPassword(signUpDTO.getPassword());
		

		return userRegisterRepo.save(userRegister);
	}

	
	@Transactional
	@Override
	public void disableLogin(int loginID)
	{
		loginRepo.disableLoginByLoginID(loginID);
	}

	@Transactional
	@Override
	public void enableLogin(int loginID)
	{
		loginRepo.enableLoginByLoginID(loginID);
	}


	@Override
	public UserDetails loadUserByUsername(String username)
	{
		UserRegister userRegister = userRegisterRepo.findByUsername(username);
				
		if(userRegister == null)
		{
			return null;
		}
			
		System.out.println(userRegister.getLogin().getPassword());
		return new org.springframework.security.core.userdetails.User(userRegister.getLogin().getUsername(),userRegister.getLogin().getPassword(),new ArrayList<>());
	}
}
