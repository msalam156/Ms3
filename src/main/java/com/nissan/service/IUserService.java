package com.nissan.service;

import java.util.List;

import com.nissan.dto.LoginDTO;
import com.nissan.dto.SignUpDTO;
import com.nissan.model.UserRegister;
import com.nissan.model.UserType;

public interface IUserService
{
	
	//Find All Users
	List<UserRegister> findAllUserRegister();
	
	//Find All UserType
	List<UserType> findAllUserType();
	
	//Find User By Username & Password		-->			Login
	UserRegister findUserByUsernamePassword(LoginDTO loginDTO);
	
	//Find User By UserID
	UserRegister findUserByUserID(int userID);
	
	//Find User By UserID
	UserRegister findByUsername(String username);
	
	//Sign Up User
	UserRegister addUserRegister(SignUpDTO signUpDTO);
	
	//Update User
	UserRegister updateUserRegister(SignUpDTO signUpDTO, int userID);
	
	//Disable User's Login
	void disableLogin(int loginID);
	
	//Enable User's Login
	void enableLogin(int loginID);


}
