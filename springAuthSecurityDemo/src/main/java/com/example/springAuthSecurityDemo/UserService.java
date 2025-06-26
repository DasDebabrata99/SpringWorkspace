package com.example.springAuthSecurityDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserDBQuery usersDBQuery;

	@Override
	public UserHelper loadUserByUsername(final String username) throws UsernameNotFoundException {
		UserPojo usersPojo = null;
		try {
			usersPojo = usersDBQuery.getUserDetails(username);
			UserHelper userDetail = new UserHelper(usersPojo);
			return userDetail;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
	}

}
