package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.nissan.model.UserRegister;

public interface IUserRegisterRepo  extends JpaRepositoryImplementation<UserRegister,Integer>
{
	//Spring Data JPA -- JpaRepositoryImplementation
	
	//Find by Username & Password
	@Query("from UserRegister where loginID = (select loginID from Login where username = ?1 and password = ?2 and isActive = true)")
	public UserRegister findByUsernamePassword(String username, String password);
	
	@Query("from UserRegister where loginID = (select loginID from Login where username = ?1 and isActive = true)")
	public UserRegister findByUsername(String username);
	
	
	//Get User by UserID
	@Query("from UserRegister where userID = ?1")
	public UserRegister findUserByUserID(int userID);
	
	//Get LoginID by UserID
	@Query("select login.loginID from UserRegister where userID = ?1")
	public int findLoginIdByUserId(int userID);
	
	
	
	
}
