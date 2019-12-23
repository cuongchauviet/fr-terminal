/**
 * 
 */
package com.elcom.gasscale.service.impl;


import java.util.HashSet;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.UserDTO;
import com.elcom.gasscale.entities.Role;
import com.elcom.gasscale.entities.User;
import com.elcom.gasscale.exception.ResourceNotFoundException;
import com.elcom.gasscale.repository.RoleRepository;
import com.elcom.gasscale.repository.UserRepository;
import com.elcom.gasscale.service.UserService;

/**
 * @author cuongcv
 *
 */
@Service
//@Transactional
public class UserServiceImpl extends GeneralMessage implements UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
    private RoleRepository roleRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;
    
    @Autowired
	private ModelMapper modelMapper;
    
	@Override
	public User getUserById(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

	@Override
	public void updateUser(User user) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insertUser(UserDTO userDTO) throws ResourceNotFoundException {
		if(userDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		User userResult = null;
		if(userRepository.findByPhone(userDTO.getPhone()) == null) {
			User user = modelMapper.map(userDTO, User.class);
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findByName(userDTO.getRole()));
			user.setRoles(roles);
			user.setPwd(passwordEncoder.encode(userDTO.getPwd()));
			userResult = userRepository.save(user);
		} else {
			throw new ResourceNotFoundException(messageRecordExist);
		}
		return userResult != null ? true : false;
	}

	@Override
	public List<User> getAllUser() throws Exception {
		return userRepository.findAll();
	}

}
