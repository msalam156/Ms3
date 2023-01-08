package com.nissan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.config.JwtTokenUtil;
import com.nissan.dto.JwtResponse;
import com.nissan.dto.LoginDTO;
import com.nissan.dto.SignUpDTO;
import com.nissan.model.UserRegister;
import com.nissan.service.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("api/")
public class LoginController
{
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserServiceImpl userDetailsService;

	// Authenticate Login
	@PostMapping("userlogin")
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody LoginDTO authenticationRequest)
			throws Exception
	{
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		// Checking if User Exist or Not
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		//Check For User exist Or Not
		if(userDetails == null)
		{
			System.out.println("Username Not Found");
			return null;
		}
		// Generating Token
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		UserRegister userRegister = userDetailsService.findByUsername(authenticationRequest.getUsername());


		//Taking Username & UserType
		String username = userRegister.getLogin().getUsername();
		Integer userTypeID = userRegister.getLogin().getUserType().getUserTypeID();

		return new ResponseEntity<JwtResponse>(new JwtResponse(token, username, userTypeID), HttpStatus.OK);
	}
	
	// Authenticate Login
	@Transactional
	@PostMapping("userRegister")
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody SignUpDTO signUpDTO)
			throws Exception
	{
		UserRegister userRegister = userDetailsService.addUserRegister(signUpDTO);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(userRegister.getLogin().getUsername());
		
		// Generating Token
		final String token = jwtTokenUtil.generateToken(userDetails);

		//Taking Username & UserType
		String username = userRegister.getLogin().getUsername();
		Integer userTypeID = userRegister.getLogin().getUserType().getUserTypeID();

		return new ResponseEntity<JwtResponse>(new JwtResponse(token, username, userTypeID), HttpStatus.OK);
	}
	

	private void authenticate(String username, String password) throws Exception
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch (DisabledException e)
		{
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e)
		{
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
