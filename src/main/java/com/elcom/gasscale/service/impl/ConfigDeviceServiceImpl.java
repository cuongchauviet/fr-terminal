package com.elcom.gasscale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.entities.ConfigDevice;
import com.elcom.gasscale.exception.ResourceNotFoundException;
import com.elcom.gasscale.model.MdlConfigDevice;
import com.elcom.gasscale.repository.ConfigRepository;
import com.elcom.gasscale.service.ConfigDeviceService;

@Service
public class ConfigDeviceServiceImpl implements ConfigDeviceService {
	
	private final ConfigRepository configRepository;
	
	
	@Autowired
	public ConfigDeviceServiceImpl(ConfigRepository configRepository) {
		this.configRepository = configRepository;
	}
	
	@Override
	public MdlConfigDevice getTopConfig() throws ResourceNotFoundException {
		MdlConfigDevice mdlConfigDevice =  new MdlConfigDevice();
		ConfigDevice configDevice = configRepository.findById(1).get();
		mdlConfigDevice.setIdTypeGasTank(configDevice.getTypeGasTank().getId());
		mdlConfigDevice.setNameGasTank(configDevice.getTypeGasTank().getNameGasTank());
		mdlConfigDevice.setWarningPercentBattery(configDevice.getWarningPercentBattery());
		mdlConfigDevice.setWarningPercentGas(configDevice.getWarningPercentGas());
		mdlConfigDevice.setWeightCrustGasTank(configDevice.getTypeGasTank().getWeightCrustGasTank());
		mdlConfigDevice.setWeightInsidesGasTank(configDevice.getTypeGasTank().getWeightInsidesGasTank());
		return mdlConfigDevice;
	}

	@Override
	public List<MdlConfigDevice> getAllConfig() throws ResourceNotFoundException{
		return null;
	}
}
