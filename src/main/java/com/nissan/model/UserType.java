package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "UserType")
public class UserType
{
	
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Fields
	private int userTypeID;
	
	private String userTypeName;
	
	//For One UserType Many Login
	@JsonIgnore
	@OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
	private List<Login> logins;

	
	//Default Constructor
	public UserType()
	{
		super();
	}

	
	//Parameterized Constructor
	public UserType(int userTypeID, String userTypeName, List<Login> logins)
	{
		super();
		this.userTypeID = userTypeID;
		this.userTypeName = userTypeName;
		this.logins = logins;
	}

	
	//Getters & Setters
	public int getUserTypeID() {
		return userTypeID;
	}

	public void setUserTypeID(int userTypeID) {
		this.userTypeID = userTypeID;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	
	//Overriding toString()
	@Override
	public String toString() {
		return String.format("UserType [userTypeID=%s, userTypeName=%s, logins=%s]", userTypeID, userTypeName, logins);
	} 
	
	
	
}
