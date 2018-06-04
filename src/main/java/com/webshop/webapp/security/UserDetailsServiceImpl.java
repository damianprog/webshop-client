package com.webshop.webapp.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.utils.SessionInitializer;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private SessionInitializer sessionInitializer;

	@Autowired
	private GrantedAuthoritiesGetter grantedAuthoritiesGetter;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (!userService.isUserNameAvailable(username)) {
			User user = userService.getUserByUserName(username);

				Set<GrantedAuthority> grantedAuthorities = grantedAuthoritiesGetter.getUserAuthorities(user);

				sessionInitializer.initialize(user);

				return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
						grantedAuthorities);

		} else
			throw new UsernameNotFoundException(username);

	}

}
