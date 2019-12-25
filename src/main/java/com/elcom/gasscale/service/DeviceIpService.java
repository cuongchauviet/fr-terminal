/**
 * 
 */
package com.elcom.gasscale.service;

import java.util.List;

import com.elcom.gasscale.dto.DeviceIpDTO;
import com.elcom.gasscale.entities.DeviceIp;

/**
 * @author cuongcv
 *
 */
public interface DeviceIpService {
	
	public List<DeviceIp> getAll() throws Exception;
	
	public DeviceIp getById(int id) throws Exception;
	
	public boolean update(DeviceIpDTO deviceIpDTO) throws Exception;
	
	public boolean insert(DeviceIpDTO deviceIpDTO) throws Exception;
	
	public boolean delete(int id) throws Exception;
}
