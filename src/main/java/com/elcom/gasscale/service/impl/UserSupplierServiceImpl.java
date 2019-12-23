/**
 * 
 */
package com.elcom.gasscale.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.UserSupplierDTO;
import com.elcom.gasscale.entities.UserSupplier;
import com.elcom.gasscale.exception.ResourceNotFoundException;
import com.elcom.gasscale.repository.UserSupplierRepository;
import com.elcom.gasscale.service.UserSupplierService;

/**
 * @author cuongcv
 *
 */
@Service
public class UserSupplierServiceImpl extends GeneralMessage implements UserSupplierService {
	
	private final UserSupplierRepository userSupplierRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public UserSupplierServiceImpl(UserSupplierRepository userSupplierRepository) {
		this.userSupplierRepository = userSupplierRepository;
	}

	@Override
	public List<UserSupplier> getAllUserSupplier() throws Exception {
		List<UserSupplier> jobEntitys = userSupplierRepository.getAllByStatusIsZero();
		return jobEntitys;
	}

	@Override
	public UserSupplier getUserSupplierById(int id) throws Exception {
		return userSupplierRepository.getById(id);
	}

	@Override
	public boolean insertSupplier(UserSupplierDTO userSupplierDTO) throws Exception {
		if(userSupplierDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		if(userSupplierRepository.findByPhone(userSupplierDTO.getPhone()) != null) {
			throw new ResourceNotFoundException(messageRecordExist);
		}
		UserSupplier user = modelMapper.map(userSupplierDTO, UserSupplier.class);
		
		UserSupplier userResult = userSupplierRepository.save(user);
		
		return userResult != null;
	}

	@Override
	public boolean updateSupplier(UserSupplierDTO userSupplierDTO) throws Exception {
		if(userSupplierDTO == null) {
			throw new ResourceNotFoundException(messageFormDataNull);
		}
		UserSupplier user = userSupplierRepository.getById((int)userSupplierDTO.getUserSupplierId());
		if(user == null) {
			throw new ResourceNotFoundException(messageRecordNotExist);
		}
		modelMapper.map(userSupplierDTO, user);
		
		UserSupplier userResult = userSupplierRepository.save(user);
		
		return userResult != null;
	}

	@Override
	public boolean delete(int id) throws Exception {
		UserSupplier user = userSupplierRepository.getById(id);
		if(user == null) {
			throw new ResourceNotFoundException(messageRecordNotExist);
		}
		user.setStatus((short)1);
		UserSupplier userResult = userSupplierRepository.save(user);
		return userResult != null;
	}
}
