/**
 * 
 */
package com.elcom.gasscale.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.GasTankDTO;
import com.elcom.gasscale.entities.GasTank;
import com.elcom.gasscale.entities.TypeGasTank;
import com.elcom.gasscale.exception.ResourceNotFoundException;
import com.elcom.gasscale.repository.GasTankRepository;
import com.elcom.gasscale.repository.TypeGasTankRepository;
import com.elcom.gasscale.repository.UserCustomerRepository;
import com.elcom.gasscale.service.GastankService;

/**
 * @author cuongcv
 *
 */
@Service
public class GastankServiceImpl extends GeneralMessage implements GastankService {
	
	private final GasTankRepository gasTankRepository;
	
	private final TypeGasTankRepository typeGasTankRepository;
	
	private final UserCustomerRepository userCustomerRepository;
	
	private final TypeGasTankServiceImpl typeGasTankServiceImpl;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public GastankServiceImpl(GasTankRepository gasTankRepository, TypeGasTankRepository typeGasTankRepository, UserCustomerRepository userCustomerRepository, TypeGasTankServiceImpl typeGasTankServiceImpl) {
		this.gasTankRepository = gasTankRepository;
		this.typeGasTankRepository = typeGasTankRepository;
		this.userCustomerRepository = userCustomerRepository;
		this.typeGasTankServiceImpl = typeGasTankServiceImpl;
	}
	
	
	@Override
	public List<GasTank> getAllGastank() throws Exception {
		return gasTankRepository.getAll();
	}


	@Override
	public GasTank getGastankById(int id) throws Exception {
		return gasTankRepository.getById(id);
	}

	@Override
	public boolean insert(GasTankDTO gasTankDTO) throws Exception {
		if(gasTankDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		GasTank gasTank = modelMapper.map(gasTankDTO, GasTank.class);
		if(gasTankDTO.getTypeGasTank() == 0 && gasTankDTO.getTypeGasTankDTO() != null) {
			TypeGasTank typeGasTank = typeGasTankServiceImpl.insertReturnResponse(gasTankDTO.getTypeGasTankDTO());
			if(typeGasTank != null) {
				gasTank.setTypeGasTank(typeGasTank);
			} else {
				throw new ResourceNotFoundException(insertError);
			}
		} else {
			gasTank.setTypeGasTank(typeGasTankRepository.getById(gasTankDTO.getTypeGasTank()));
		}
		gasTank.setUserCustomer(userCustomerRepository.getById(gasTankDTO.getIdUser()));
		GasTank gasTankResual = gasTankRepository.save(gasTank);
		return gasTankResual != null;
	}


	@Override
	public boolean update(GasTankDTO gasTankDTO) throws Exception {
		if(gasTankDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		GasTank gasTank = gasTankRepository.getById((int)gasTankDTO.getId());
		if(gasTank == null) {
			throw new ResourceNotFoundException(messageRecordNotExist);
		}
		modelMapper.map(gasTankDTO, gasTank);
		gasTank.setTypeGasTank(typeGasTankRepository.getById(gasTankDTO.getTypeGasTank()));
		gasTank.setUserCustomer(userCustomerRepository.getById(gasTankDTO.getIdUser()));
		GasTank gasTankResual = gasTankRepository.save(gasTank);
		return gasTankResual != null;
	}

	@Override
	public boolean delete(int id) throws Exception {
		GasTank gasTank = gasTankRepository.getById(id);
		if(gasTank == null) {
			throw new ResourceNotFoundException(messageRecordNotExist);
		}
		gasTank.setStatus((short)1);
		GasTank gasTankResult = gasTankRepository.save(gasTank);
		return gasTankResult != null;
	}
}
