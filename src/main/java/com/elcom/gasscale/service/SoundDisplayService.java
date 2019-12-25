/**
 * 
 */
package com.elcom.gasscale.service;

import java.util.List;

import com.elcom.gasscale.dto.SoundDisplayDTO;
import com.elcom.gasscale.entities.SoundDisplay;

/**
 * @author cuongcv
 *
 */
public interface SoundDisplayService {
	
	public SoundDisplay getTopById(int id) throws Exception;
	
	public boolean insert(SoundDisplayDTO soundDisplayDTO) throws Exception;
	
	public boolean update(SoundDisplayDTO soundDisplayDTO) throws Exception;
	
	public boolean delete(int id) throws Exception;
	
	public List<SoundDisplay> getAll() throws Exception;
}
