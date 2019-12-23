/**
 * 
 */
package com.elcom.gasscale.service;

import com.elcom.gasscale.dto.TypeGasTankDTO;
import com.elcom.gasscale.entities.TypeGasTank;

/**
 * @author cuongcv
 *
 */
public interface TypeGasTankService {
	
	public TypeGasTank getTopById() throws Exception;
	
	public boolean insert(TypeGasTankDTO typeGasTankDTO) throws Exception;
	
	public TypeGasTank insertReturnResponse(TypeGasTankDTO typeGasTankDTO) throws Exception;
}
