/**
 * 
 */
package com.elcom.gasscale.service;

import java.util.List;

import com.elcom.gasscale.dto.ParameterEnvironmentSystemDTO;
import com.elcom.gasscale.entities.ParameterEnvironmentSystem;

/**
 * @author cuongcv
 *
 */
public interface ParameterEnvironmentSystemService {
	
	public ParameterEnvironmentSystem getById(int id) throws Exception;
	
	public boolean insert(ParameterEnvironmentSystemDTO parameterEnvironmentSystemDTO) throws Exception;
	
	public boolean update(ParameterEnvironmentSystemDTO parameterEnvironmentSystemDTO) throws Exception;
	
	public boolean delete(int id) throws Exception;
	
	public List<ParameterEnvironmentSystem> getAll() throws Exception;
}
