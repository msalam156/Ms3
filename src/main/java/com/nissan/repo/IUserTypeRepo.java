package com.nissan.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.nissan.model.UserType;

public interface IUserTypeRepo  extends JpaRepositoryImplementation<UserType,Integer>
{
	
}
