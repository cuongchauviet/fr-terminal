/**
 * 
 */
package com.elcom.gasscale.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.LogSystemDTO;
import com.elcom.gasscale.entities.LogSystem;
import com.elcom.gasscale.exception.ResourceNotFoundException;
import com.elcom.gasscale.logic.PageableLogic;
import com.elcom.gasscale.repository.LogSystemReporitory;
import com.elcom.gasscale.service.LogSystemService;

/**
 * @author cuongcv
 *
 */
@Service
public class LogSystemServiceImpl extends GeneralMessage implements LogSystemService {
	
	private final LogSystemReporitory logSystemReporitory;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public LogSystemServiceImpl(LogSystemReporitory logSystemReporitory) {
		this.logSystemReporitory = logSystemReporitory;
	}

	@Override
	public LogSystem getById(int id) throws Exception {
		return logSystemReporitory.findById(id);
	}

	@Override
	public boolean insert(LogSystemDTO logSystemDTO) throws Exception {
		if(logSystemDTO == null) {
			throw new Exception(messageFormDataNull);
		}
		LogSystem logSystem = modelMapper.map(logSystemDTO, LogSystem.class);
		LogSystem  logSystemResult = logSystemReporitory.save(logSystem);
		return logSystemResult != null;
	}

	@Override
	public boolean update(LogSystemDTO logSystemDTO) throws Exception {
		if(logSystemDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		LogSystem logSystem = logSystemReporitory.getById((int)logSystemDTO.getId()).orElseThrow(()-> new Exception(messageRecordNotExist));
		modelMapper.map(logSystemDTO, logSystem);
		LogSystem logSystemResult = logSystemReporitory.save(logSystem);
		return logSystemResult != null;
	}

	@Override
	public void delete(int id) throws Exception {
		logSystemReporitory.deleteById(id);
	}

	@Override
	public List<LogSystem> getAll(long startTime, long endTime, byte dataType, int pageNumber, int pageSize, String sortCol, String sortDirect) throws Exception {
		Sort sort = PageableLogic.sortSetDefault(sortCol, sortDirect);
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		return logSystemReporitory.getAll((int)startTime, (int)endTime, dataType, pageable);
	}

}
