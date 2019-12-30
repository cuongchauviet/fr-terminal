/**
 * 
 */
package com.elcom.gasscale.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.ParameterEnvironmentSystemDTO;
import com.elcom.gasscale.entities.ParameterEnvironmentSystem;
import com.elcom.gasscale.logic.PageableEnum;
import com.elcom.gasscale.repository.ParameterEnvironmentSystemRepository;
import com.elcom.gasscale.service.ParameterEnvironmentSystemService;

/**
 * @author cuongcv
 *
 */
@Service
public class ParameterEnvironmentSystemServiceImpl extends GeneralMessage implements ParameterEnvironmentSystemService {

	private final ParameterEnvironmentSystemRepository parameterEnvironmentSystemRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public ParameterEnvironmentSystemServiceImpl(ParameterEnvironmentSystemRepository parameterEnvironmentSystemRepository) {
		this.parameterEnvironmentSystemRepository = parameterEnvironmentSystemRepository;
	}
	
	@Override
	public ParameterEnvironmentSystem getById(int id) throws Exception {
		return parameterEnvironmentSystemRepository.findById(id);
	}

	@Override
	public boolean insert(ParameterEnvironmentSystemDTO parameterEnvironmentSystemDTO) throws Exception {
		if(parameterEnvironmentSystemDTO == null) {
			throw new Exception(messageFormDataNull);
		}
		ParameterEnvironmentSystem parameterEnvironmentSystem = modelMapper.map(parameterEnvironmentSystemDTO, ParameterEnvironmentSystem.class);
		ParameterEnvironmentSystem  parameterEnvironmentSystemResult = parameterEnvironmentSystemRepository.save(parameterEnvironmentSystem);
		return parameterEnvironmentSystemResult != null;
	}

	@Override
	public boolean update(ParameterEnvironmentSystemDTO parameterEnvironmentSystemDTO) throws Exception {
		if(parameterEnvironmentSystemDTO == null) {
			throw new Exception(messageFormDataNull);
		}
		ParameterEnvironmentSystem parameterEnvironmentSystem = parameterEnvironmentSystemRepository.getById((int)parameterEnvironmentSystemDTO.getId()).orElseThrow(() -> new Exception(messageRecordNotExist));
		modelMapper.map(parameterEnvironmentSystemDTO, parameterEnvironmentSystem);
		ParameterEnvironmentSystem parameterEnvironmentSystemResult = parameterEnvironmentSystemRepository.save(parameterEnvironmentSystem); 
		return parameterEnvironmentSystemResult != null;
	}

	@Override
	public boolean delete(int id) throws Exception {
		ParameterEnvironmentSystem parameterEnvironmentSystem = parameterEnvironmentSystemRepository.getById(id).orElseThrow(() -> new Exception(messageRecordNotExist));
		parameterEnvironmentSystem.setStatus(PageableEnum.STATUS_DISABLE);
		ParameterEnvironmentSystem parameterEnvironmentSystemResult = parameterEnvironmentSystemRepository.save(parameterEnvironmentSystem); 
		return parameterEnvironmentSystemResult != null;
	}

	@Override
	public List<ParameterEnvironmentSystem> getAll() throws Exception {
		return parameterEnvironmentSystemRepository.getAll();
	}

}
