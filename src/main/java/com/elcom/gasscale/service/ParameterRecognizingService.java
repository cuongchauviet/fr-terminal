/**
 * 
 */
package com.elcom.gasscale.service;

import java.util.List;

import com.elcom.gasscale.dto.ParameterRecognizingDTO;
import com.elcom.gasscale.entities.ParameterRecognizing;
/**
 * @author cuongcv
 *
 */
public interface ParameterRecognizingService {
	
	public List<ParameterRecognizing> getAll() throws Exception;
	
	public ParameterRecognizing getById(int id) throws Exception;
	
	public boolean insert(ParameterRecognizingDTO parameterRecognizingDTO) throws Exception;
	
	public boolean update(ParameterRecognizingDTO parameterRecognizingDTO) throws Exception;
	
	public boolean delete(int id) throws Exception;
	
}
