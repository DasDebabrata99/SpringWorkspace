package com.securitydemo.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.securitydemo.MyUserDetailsService;

public class JwtRequestFilter  extends OncePerRequestFilter {
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	MyUserDetailsService userDetailService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String authorizationHeader = request.getHeader("Authorization");
		String username=null;
		String jwt = null;
		if(authorizationHeader!=null & authorizationHeader.startsWith("Bearer")) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(jwt);
			
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = userDetailService.loadUserByUsername(username);
			if(jwtUtil.validateToken(jwt, userDetails)) {
			UsernamePasswordAuthenticationToken uptoken = new UsernamePasswordAuthenticationToken(
					userDetails,userDetails.getUsername());
			uptoken.setDetails(
					new WebAuthenticationDetailsSource()
					.buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(uptoken);
			}
		}
		chain.doFilter(request,response);
	
	}

}
