/**
 * 
 */
package com.elcom.gasscale.service;

import java.util.List;

import com.elcom.gasscale.dto.TimeSystemDTO;
import com.elcom.gasscale.entities.TimeSystem;
import com.elcom.gasscale.exception.ResourceNotFoundException;

/**
 * @author cuongcv
 *
 */
public interface TimeSystemService {
	
	public List<TimeSystem> getAll() throws Exception;
	
	public TimeSystem getById(int id) throws ResourceNotFoundException;
	
	public boolean update(TimeSystemDTO timeSystemDTO) throws ResourceNotFoundException;
	
	public boolean insert(TimeSystemDTO timeSystemDTO) throws ResourceNotFoundException;
	
	public boolean delete(int id) throws ResourceNotFoundException;
}
