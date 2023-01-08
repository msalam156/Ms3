package com.nissan.dto;

public class SignUpDTO
{
	//Declare Fields
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String address;
	private String phoneNo;
	private String username;
	private String password;
	private int userTypeID;
	
	
	//Default Constructor
	public SignUpDTO()
	{
		super();
	}
	
	
	//Parameterized Constructor
	public SignUpDTO(String firstName, String lastName, int age, String gender, String address, String phoneNo,
			String username, String password, int userTypeID)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.username = username;
		this.password = password;
		this.userTypeID = userTypeID;
	}
	
	//Getters & Setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
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
	
	
	//Overriding toString()
	@Override
	public String toString()
	{
		return String.format(
				"SignUpDTO [firstName=%s, lastName=%s, age=%s, gender=%s, address=%s, phoneNo=%s, username=%s, password=%s, userTypeID=%s]",
				firstName, lastName, age, gender, address, phoneNo, username, password, userTypeID);
	}
	


}
