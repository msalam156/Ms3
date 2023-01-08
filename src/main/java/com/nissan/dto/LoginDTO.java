package com.nissan.dto;

public class LoginDTO
{
	//Declare Fields
	private String username;
	private String password;
	private int userTypeID;
	
	//Default Constructor
	public LoginDTO()
	{
		super();
	}
	
	
	//Parameterized Constructor
	public LoginDTO(String username, String password, int userTypeID)
	{
		super();
		this.username = username;
		this.password = password;
		this.userTypeID = userTypeID;
	}
	
	
	//Getters & Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserTypeID() {
		return userTypeID;
	}
	public void setUserTypeID(int userTypeID) {
		this.userTypeID = userTypeID;
	}
	
	
	//Override toString()
	@Override
	public String toString()
	{
		return String.format("LoginDTO [username=%s, password=%s, userTypeID=%s]", username, password, userTypeID);
	}
	
	
}
