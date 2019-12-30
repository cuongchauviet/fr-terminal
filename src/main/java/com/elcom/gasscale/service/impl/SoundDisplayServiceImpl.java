/**
 * 
 */
package com.elcom.gasscale.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.SoundDisplayDTO;
import com.elcom.gasscale.entities.SoundDisplay;
import com.elcom.gasscale.logic.PageableEnum;
import com.elcom.gasscale.repository.SoundDisplayRepository;
import com.elcom.gasscale.service.SoundDisplayService;

/**
 * @author cuongcv
 *
 */
@Service
public class SoundDisplayServiceImpl extends GeneralMessage implements SoundDisplayService {
	
	@Autowired
	private SoundDisplayRepository soundDisplayRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public SoundDisplay getTopById(int id) throws Exception {
		return soundDisplayRepository.findById(id);
	}

	@Override
	public boolean insert(SoundDisplayDTO soundDisplayDTO) throws Exception {
		if(soundDisplayDTO == null) {
			throw new Exception(messageFormDataNull);
		}
		SoundDisplay soundDisplay = modelMapper.map(soundDisplayDTO, SoundDisplay.class);
		SoundDisplay  soundDisplayResult = soundDisplayRepository.save(soundDisplay);
		return soundDisplayResult != null;
	}

	@Override
	public boolean update(SoundDisplayDTO soundDisplayDTO) throws Exception {
		if(soundDisplayDTO == null) {
			throw new Exception(messageFormDataNull);
		}
		SoundDisplay soundDisplay = soundDisplayRepository.getById((int)soundDisplayDTO.getId()).orElseThrow(() -> new Exception(messageRecordNotExist));
		modelMapper.map(soundDisplayDTO, soundDisplay);
		SoundDisplay soundDisplayResult = soundDisplayRepository.save(soundDisplay); 
		return soundDisplayResult != null;
	}

	@Override
	public boolean delete(int id) throws Exception {
		SoundDisplay soundDisplay = soundDisplayRepository.getById(id).orElseThrow(() -> new Exception(messageRecordNotExist));
		soundDisplay.setStatus(PageableEnum.STATUS_DISABLE);
		SoundDisplay soundDisplayResult = soundDisplayRepository.save(soundDisplay); 
		return soundDisplayResult != null;
	}

	@Override
	public List<SoundDisplay> getAll() throws Exception {
		return soundDisplayRepository.getAll();
	}

}
