/**
 * 
 */
package com.elcom.gasscale.service;

import java.util.List;

import com.elcom.gasscale.dto.LogSystemDTO;
import com.elcom.gasscale.entities.LogSystem;

/**
 * @author cuongcv
 *
 */
public interface LogSystemService {
	
	public LogSystem getById(int id) throws Exception;
	
	public boolean insert(LogSystemDTO logSystemDTO) throws Exception;
	
	public boolean update(LogSystemDTO logSystemDTO) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<LogSystem> getAll(long startTime, long endTime, byte dataType, int pageNumber, int pageSize, String sortCol, String sortDirect) throws Exception;
	
}
