/**
 * 
 */
package com.elcom.gasscale.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.ParameterRecognizingDTO;
import com.elcom.gasscale.entities.ParameterRecognizing;
import com.elcom.gasscale.exception.ResourceNotFoundException;
import com.elcom.gasscale.repository.ParameterRecognizingRepository;
import com.elcom.gasscale.service.ParameterRecognizingService;

/**
 * @author cuongcv
 *
 */
@Service
public class ParameterRecognizingServiceImpl extends GeneralMessage implements ParameterRecognizingService {
	
	private final ParameterRecognizingRepository parameterRecognizingRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public ParameterRecognizingServiceImpl(ParameterRecognizingRepository parameterRecognizingRepository) {
		this.parameterRecognizingRepository = parameterRecognizingRepository;
	}

	@Override
	public List<ParameterRecognizing> getAll() throws Exception {
		return parameterRecognizingRepository.getAllByStatusIsZero();
	}

	@Override
	public ParameterRecognizing getById(int id) throws Exception {
		return parameterRecognizingRepository.getById(id);
	}

	@Override
	public boolean insert(ParameterRecognizingDTO parameterRecognizingDTO) throws Exception {
		if(parameterRecognizingDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		ParameterRecognizing parameterRecognizing = modelMapper.map(parameterRecognizingDTO, ParameterRecognizing.class);
		ParameterRecognizing parameterRecognizingResult = parameterRecognizingRepository.save(parameterRecognizing);
		return parameterRecognizingResult != null;
	}

	@Override
	public boolean update(ParameterRecognizingDTO parameterRecognizingDTO) throws Exception {
		if(parameterRecognizingDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		ParameterRecognizing parameterRecognizing = parameterRecognizingRepository.getById((int)parameterRecognizingDTO.getId());
		if(parameterRecognizing == null) {
			throw new ResourceNotFoundException(messageRecordNotExist);
		}
		modelMapper.map(parameterRecognizingDTO, parameterRecognizing);
		ParameterRecognizing userResult = parameterRecognizingRepository.save(parameterRecognizing);
		return userResult != null;
	}

	@Override
	public boolean delete(int id) throws Exception {
		ParameterRecognizing parameterRecognizing = parameterRecognizingRepository.getById(id);
		if(parameterRecognizing == null) {
			throw new ResourceNotFoundException(messageRecordNotExist);
		}
		parameterRecognizing.setStatus((short)1);
		ParameterRecognizing userResult = parameterRecognizingRepository.save(parameterRecognizing);
		return userResult != null;
	}
}
