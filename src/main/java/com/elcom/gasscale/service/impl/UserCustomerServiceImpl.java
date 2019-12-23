/**
 * 
 */
package com.elcom.gasscale.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.dto.UserCustomerDTO;
import com.elcom.gasscale.entities.UserCustomer;
import com.elcom.gasscale.repository.UserCustomerRepository;
import com.elcom.gasscale.service.UserCustomerService;

/**
 * @author cuongcv
 *
 */
@Service
public class UserCustomerServiceImpl implements UserCustomerService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final UserCustomerRepository userCustomerRepository;
	
	@Autowired
	public UserCustomerServiceImpl(UserCustomerRepository userCustomerRepository) {
		this.userCustomerRepository  = userCustomerRepository;
	}
	
	@Override
	public UserCustomer getUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(UserCustomer userCustomer) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean insertUser(UserCustomerDTO userCustomerDTO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserCustomer> getAllUser() throws Exception {
		return userCustomerRepository.getAll();
	}

}
