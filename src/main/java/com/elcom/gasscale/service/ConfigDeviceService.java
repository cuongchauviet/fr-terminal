package com.elcom.gasscale.service;

import java.util.List;

import com.elcom.gasscale.exception.ResourceNotFoundException;
import com.elcom.gasscale.model.MdlConfigDevice;

public interface ConfigDeviceService {
	
	public MdlConfigDevice getTopConfig() throws ResourceNotFoundException;
	
	public List<MdlConfigDevice> getAllConfig() throws ResourceNotFoundException;
}
