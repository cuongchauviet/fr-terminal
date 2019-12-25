/**
 * 
 */
package com.elcom.gasscale.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.TimeSystemDTO;
import com.elcom.gasscale.entities.TimeSystem;
import com.elcom.gasscale.exception.ResourceNotFoundException;
import com.elcom.gasscale.repository.TimeSystemRepository;
import com.elcom.gasscale.service.TimeSystemService;

/**
 * @author cuongcv
 *
 */
@Service
public class TimeSystemServiceImpl extends GeneralMessage implements TimeSystemService {
	
	private final TimeSystemRepository timeSystemRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public TimeSystemServiceImpl(TimeSystemRepository timeSystemRepository) {
		this.timeSystemRepository = timeSystemRepository;
	}
	
	@Override
	public List<TimeSystem> getAll() throws Exception {
		return timeSystemRepository.getAll();
	}

	@Override
	public TimeSystem getById(int id) throws ResourceNotFoundException {
		return timeSystemRepository.findById(id);
	}

	@Override
	public boolean update(TimeSystemDTO timeSystemDTO) throws ResourceNotFoundException {
		if(timeSystemDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		TimeSystem timeSystem = timeSystemRepository.getById((int)timeSystemDTO.getId()).orElseThrow(() -> new ResourceNotFoundException(messageRecordNotExist));
		modelMapper.map(timeSystemDTO, timeSystem);
		TimeSystem timeSystemResult = timeSystemRepository.save(timeSystem); 
		return timeSystemResult != null;
	}

	@Override
	public boolean insert(TimeSystemDTO timeSystemDTO) throws ResourceNotFoundException {
		if(timeSystemDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		TimeSystem timeSystem = modelMapper.map(timeSystemDTO, TimeSystem.class);
		TimeSystem  timeSystemResult = timeSystemRepository.save(timeSystem);
		return timeSystemResult != null;
	}

	@Override
	public boolean delete(int id) throws ResourceNotFoundException {
		TimeSystem timeSystem = timeSystemRepository.getById(id).orElseThrow(() -> new ResourceNotFoundException(messageRecordNotExist));
		timeSystem.setStatus((short)1);
		TimeSystem timeSystemResult = timeSystemRepository.save(timeSystem); 
		return timeSystemResult != null;
	}

}
