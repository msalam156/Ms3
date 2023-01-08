package com.nissan.model;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nissan.dto.SignUpDTO;

@Entity
@Table(name = "UserRegister")
public class UserRegister
{
	
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	@Column(nullable = false)
	private String firstName;
	private String lastName;

	@Column(nullable = false)
	private int age;
	
	private String gender;
	private String address;
	
	@Column(nullable = false, unique = true)
	private String phoneNo;
	
	//Join Column			User.loginID = Login.loginID
	@JoinColumn(name = "loginID")
	@OneToOne
	private Login login;

	
	//Default Constructor
	public UserRegister()
	{
		super();
	}
	
	
	//Copy Constructor for SignUpDTO
	public UserRegister(SignUpDTO signUpDTO, Login login)
	{
		this.firstName = signUpDTO.getFirstName();
		this.lastName = signUpDTO.getLastName();
		this.age = signUpDTO.getAge();
		this.gender = signUpDTO.getGender();
		this.address = signUpDTO.getAddress();
		this.phoneNo = signUpDTO.getPhoneNo();
		this.login = login;
	}

	
	//Parameterized Constructor
	public UserRegister(int userID, String firstName, String lastName, int age, String gender, String address,
			String phoneNo, Login login)
	{
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.login = login;
	}

	
	//Getters & Setters
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	
	//Override toString()
	@Override
	public String toString() {
		return String.format(
				"UserRegister [userID=%s, firstName=%s, lastName=%s, age=%s, gender=%s, address=%s, phoneNo=%s, login=%s]",
				userID, firstName, lastName, age, gender, address, phoneNo, login);
	}
	
	
	

	
	
	
	
}
