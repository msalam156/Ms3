
package com.nissan.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.nissan.model.Login;

public interface ILoginRepo  extends JpaRepositoryImplementation<Login,Integer>
{
//	//Find Login By LoginID
//	@Query("from Login where loginID = ?1 and isActive = true")
//	public Login findLoginByLoginID(int loginID);

	//Update isActive = true for Login
	@Modifying
	@Query("Update Login set isActive = true where loginID = ?1")
	public void enableLoginByLoginID(int loginID);
	
	
	//Update isActive = false for Login
	@Modifying
	@Query("Update Login set isActive = false where loginID = ?1")
	public void disableLoginByLoginID(int loginID);

	@Query("from Login where username = ?1")
	public Login findByUsername(String username);
	
	
	
	
}
