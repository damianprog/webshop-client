package com.webshop.webapp.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Role;
import com.webshop.webapp.entity.User;

@Component
public class GrantedAuthoritiesGetter {

	public Set<GrantedAuthority> getUserAuthorities(User user) {
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		
		return grantedAuthorities;
	}
	
}
