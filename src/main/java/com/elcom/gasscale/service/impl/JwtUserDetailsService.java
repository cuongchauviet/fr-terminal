package com.elcom.gasscale.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.entities.Role;
import com.elcom.gasscale.entities.User;
import com.elcom.gasscale.repository.UserRepository;

@Service
@Transactional
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByPhone(username);
		if (user != null && user.getPhone().equals(username)) {
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			Set<Role> roles = user.getRoles();
			for (Role role : roles) {
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
			return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPwd(),
					grantedAuthorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
