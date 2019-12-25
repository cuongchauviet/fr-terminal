/**
 * 
 */
package com.elcom.gasscale.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.UserFaceDTO;
import com.elcom.gasscale.entities.UserFace;
import com.elcom.gasscale.repository.UserFaceRepository;
import com.elcom.gasscale.service.UserFaceService;

/**
 * @author cuongcv
 *
 */
@Service
public class UserFaceServiceImpl extends GeneralMessage implements UserFaceService {

	@Autowired
	private ModelMapper modelMapper;
	
	private final UserFaceRepository userFaceRepository;
	
	@Autowired
	public UserFaceServiceImpl(UserFaceRepository userFaceRepository) {
		this.userFaceRepository = userFaceRepository;
	}
	

	@Override
	public UserFace getById(int id) throws Exception {
		return userFaceRepository.findById(id);
	}

	@Override
	public boolean insert(UserFaceDTO userFaceDTO) throws Exception {
		if(userFaceDTO == null) {
			throw new Exception(messageFormDataNull);
		}
		UserFace userFace = modelMapper.map(userFaceDTO, UserFace.class);
		UserFace  userFaceResult = userFaceRepository.save(userFace);
		return userFaceResult != null;
	}

	@Override
	public boolean update(UserFaceDTO userFaceDTO) throws Exception {
		if(userFaceDTO == null) {
			throw new Exception(messageFormDataNull);
		}
		UserFace userFace = userFaceRepository.getById((int)userFaceDTO.getId()).orElseThrow(() -> new Exception(messageRecordNotExist));
		modelMapper.map(userFaceDTO, userFace);
		UserFace userFaceResult = userFaceRepository.save(userFace); 
		return userFaceResult != null;
	}

	@Override
	public boolean delete(int id) throws Exception {
		UserFace userFace = userFaceRepository.getById(id).orElseThrow(() -> new Exception(messageRecordNotExist));
		userFace.setStatus((short)1);
		UserFace userFaceResult = userFaceRepository.save(userFace); 
		return userFaceResult != null;
	}

	@Override
	public List<UserFace> getAll() throws Exception {
		return userFaceRepository.getAll();
	}

}
