package com.webshop.webapp.security;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.Role;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.utils.SessionInitializer;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;

	@Autowired
	SessionInitializer sessionInitializer;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (!userService.isUserNameAvailable(username)) {
			User user = userService.getUserByUserName(username);

//			if (!user.isEnabled())
//				throw new UsernameNotFoundException(username);
				Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
				for (Role role : user.getRoles()) {
					grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
				}

				sessionInitializer.initialize(user);

				return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
						grantedAuthorities);

		} else
			throw new UsernameNotFoundException(username);

	}

}
