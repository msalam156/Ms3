package com.nissan.dto;

//This returns userName, roleId, jwtToken
public class JwtResponse
{
	private final String jwtToken;
	private String userName;
	private int roleId;
	
	//Parameterized Constructor
	public JwtResponse(String jwtToken, String userName, int roleId)
	{
		super();
		this.jwtToken = jwtToken;
		this.userName = userName;
		this.roleId = roleId;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getJwtToken() {
		return jwtToken;
	}
	
	
}
