/**
 * 
 */
package com.elcom.gasscale.service;

import java.util.List;

import com.elcom.gasscale.dto.UserDTO;
import com.elcom.gasscale.entities.User;
import com.elcom.gasscale.exception.ResourceNotFoundException;

/**
 * @author cuongcv
 *
 */
public interface UserService {
	
	public List<User> getAllUser() throws Exception;
	
	public User getUserById(int id) throws ResourceNotFoundException;
	
	public void updateUser(User user) throws ResourceNotFoundException;
	
	public boolean insertUser(UserDTO userDTO) throws ResourceNotFoundException;
	
}
