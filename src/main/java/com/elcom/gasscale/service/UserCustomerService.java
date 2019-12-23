/**
 * 
 */
package com.elcom.gasscale.service;

import java.util.List;

import com.elcom.gasscale.dto.UserCustomerDTO;
import com.elcom.gasscale.entities.UserCustomer;

/**
 * @author cuongcv
 *
 */
public interface UserCustomerService {
	
	public List<UserCustomer> getAllUser() throws Exception;
	
	public UserCustomer getUserById(int id) throws Exception;
	
	public void updateUser(UserCustomer userCustomer) throws Exception;
	
	public boolean insertUser(UserCustomerDTO userCustomerDTO) throws Exception;
}
