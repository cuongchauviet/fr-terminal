/**
 * 
 */
package com.elcom.gasscale.service;

import java.util.List;

import com.elcom.gasscale.dto.UserFaceDTO;
import com.elcom.gasscale.entities.UserFace;

/**
 * @author cuongcv
 *
 */
public interface UserFaceService {
	
	public UserFace getById(int id) throws Exception;
	
	public boolean insert(UserFaceDTO userFaceDTO) throws Exception;
	
	public boolean update(UserFaceDTO userFaceDTO) throws Exception;
	
	public boolean delete(int id) throws Exception;
	
	public List<UserFace> getAll(int pageNumber, int pageSize, String sortCol, String sortDirect) throws Exception;
}
