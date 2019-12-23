/**
 * 
 */
package com.elcom.gasscale.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.TypeGasTankDTO;
import com.elcom.gasscale.entities.TypeGasTank;
import com.elcom.gasscale.repository.TypeGasTankRepository;
import com.elcom.gasscale.service.TypeGasTankService;

/**
 * @author cuongcv
 *
 */
@Service
public class TypeGasTankServiceImpl extends GeneralMessage implements TypeGasTankService {
	
	@Autowired
	private TypeGasTankRepository typeGasTankRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public TypeGasTank getTopById() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(TypeGasTankDTO typeGasTankDTO) throws Exception {
		if(typeGasTankDTO == null) {
			throw new Exception(messageFormDataNull);
		}
		TypeGasTank typeGasTank = modelMapper.map(typeGasTankDTO, TypeGasTank.class);
		TypeGasTank  typeGasTankResult = typeGasTankRepository.save(typeGasTank);
		return typeGasTankResult != null;
	}

	@Override
	public TypeGasTank insertReturnResponse(TypeGasTankDTO typeGasTankDTO) throws Exception {
		if(typeGasTankDTO == null) {
			throw new Exception(messageFormDataNull);
		}
		TypeGasTank typeGasTank = modelMapper.map(typeGasTankDTO, TypeGasTank.class);
		TypeGasTank  typeGasTankResult = typeGasTankRepository.save(typeGasTank);
		return typeGasTankResult;
	}

}
