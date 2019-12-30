/**
 * 
 */
package com.elcom.gasscale.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.DeviceIpDTO;
import com.elcom.gasscale.entities.DeviceIp;
import com.elcom.gasscale.exception.ResourceNotFoundException;
import com.elcom.gasscale.logic.PageableEnum;
import com.elcom.gasscale.repository.DeviceIpRepository;
import com.elcom.gasscale.service.DeviceIpService;

/**
 * @author cuongcv
 *
 */
@Service
public class DeviceIpServiceImpl extends GeneralMessage implements DeviceIpService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final DeviceIpRepository deviceIpRepository;
	
	@Autowired
	public DeviceIpServiceImpl(DeviceIpRepository deviceIpRepository) {
		this.deviceIpRepository  = deviceIpRepository;
	}
	
	@Override
	public DeviceIp getById(int id) throws Exception {
		return deviceIpRepository.findById(id);
	}

	@Override
	public boolean update(DeviceIpDTO deviceIpDTO) throws Exception {
		if(deviceIpDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		DeviceIp deviceIp = deviceIpRepository.getById((int)deviceIpDTO.getId()).orElseThrow(()-> new Exception(messageRecordNotExist));
		modelMapper.map(deviceIpDTO, deviceIp);
		DeviceIp deviceIpResult = deviceIpRepository.save(deviceIp);
		return deviceIpResult != null;
	}

	@Override
	public boolean insert(DeviceIpDTO deviceIpDTO) throws Exception {
		if(deviceIpDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		DeviceIp deviceIp = modelMapper.map(deviceIpDTO, DeviceIp.class);
		DeviceIp deviceIpResult = deviceIpRepository.save(deviceIp);
		return deviceIpResult != null;
	}

	@Override
	public List<DeviceIp> getAll() throws Exception {
		return deviceIpRepository.getAll();
	}

	@Override
	public boolean delete(int id) throws Exception {
		DeviceIp deviceIp = deviceIpRepository.getById(id).orElseThrow(()-> new Exception(messageRecordNotExist));
		deviceIp.setStatus(PageableEnum.STATUS_DISABLE);
		DeviceIp deviceIpResult = deviceIpRepository.save(deviceIp);
		return deviceIpResult != null;
	}
}
