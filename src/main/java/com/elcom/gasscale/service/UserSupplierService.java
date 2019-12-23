/**
 * 
 */
package com.elcom.gasscale.service;

import java.util.List;

import com.elcom.gasscale.dto.UserSupplierDTO;
import com.elcom.gasscale.entities.UserSupplier;
/**
 * @author cuongcv
 *
 */
public interface UserSupplierService {
	
	public List<UserSupplier> getAllUserSupplier() throws Exception;
	
	public UserSupplier getUserSupplierById(int id) throws Exception;
	
	public boolean insertSupplier(UserSupplierDTO userSupplierDTO) throws Exception;
	
	public boolean updateSupplier(UserSupplierDTO userSupplierDTO) throws Exception;
	
	public boolean delete(int id) throws Exception;
	
}
