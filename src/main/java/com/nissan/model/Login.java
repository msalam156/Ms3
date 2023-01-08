package com.nissan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nissan.dto.SignUpDTO;

@Entity
@Table(name = "Login")
public class Login
{
	
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginID;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	private boolean isActive;
	
	//Join Column			Login.userTypeID = UserType.userTypeID
	@JoinColumn(name = "userTypeID")
	@ManyToOne
	private UserType userType;
	
	//For One Login One UserRegister
	@JsonIgnore
	@OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
	private UserRegister userRegister;

	
	//Default Constructor
	public Login()
	{
		super();
	}


	//Copy Constructor for SignUpDTO
	public Login(SignUpDTO signUpDTO)
	{
		this.username = signUpDTO.getUsername();
		this.password = signUpDTO.getPassword();
		this.userType = new UserType();
		this.userType.setUserTypeID(signUpDTO.getUserTypeID());
	}
	
	//Parameterized Constructor
	public Login(int loginID, String username, String password, boolean isActive, UserType userType)
	{
		super();
		this.loginID = loginID;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.userType = userType;
	}

	
	//Getters & Setters
	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	
	//Overriding toString()
	@Override
	public String toString() {
		return String.format("Login [loginID=%s, username=%s, password=%s, isActive=%s, userType=%s]", loginID,
				username, password, isActive, userType);
	}
	
	
	
	
}
