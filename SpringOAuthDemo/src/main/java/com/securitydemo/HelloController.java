package com.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.securitydemo.jwt.JwtUtil;
import com.securitydemo.model.AuthenticationRequest;
import com.securitydemo.model.AuthenticationResponse;
import com.securitydemo.model.UserResponse;

@RestController
public class HelloController { 
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	MyUserDetailsService userDetailService;
	@Autowired
	JwtUtil jwtUtil;
	
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
 
    @RequestMapping("/test")
    public UserResponse respond() {
    	return new UserResponse("han", "roudy");
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationRequest(@RequestBody AuthenticationRequest auhtenticationRequest) throws Exception {
		
    	try {
    	authenticationManager.authenticate(
    			new UsernamePasswordAuthenticationToken(auhtenticationRequest.getUsername(), 
    					auhtenticationRequest.getPassword()));
    	UserDetails userDetails = userDetailService.loadUserByUsername(auhtenticationRequest.getUsername());
    	final String jwt = jwtUtil.generateToken(userDetails);
    	AuthenticationResponse authResponse = new AuthenticationResponse(jwt);
    	
    	return ResponseEntity.ok(authResponse);
    	
    	}catch(BadCredentialsException e) {
    		throw new Exception("Incorrect username or password",e);
    	}

	}
   
}
