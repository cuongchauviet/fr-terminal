/**
 * 
 */
package com.elcom.gasscale.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.SoundDisplayDTO;
import com.elcom.gasscale.entities.SoundDisplay;
import com.elcom.gasscale.model.ResponseResult;
import com.elcom.gasscale.service.SoundDisplayService;

import io.swagger.annotations.ApiOperation;

/**
 * @author cuongcv
 *
 */
@RestController
@RequestMapping("api/sound-display")
@CrossOrigin
public class SoundDisplayController extends GeneralMessage {
	
	private final SoundDisplayService soundDisplayService;
	
	@Autowired
	public SoundDisplayController(SoundDisplayService soundDisplayService) {
		this.soundDisplayService = soundDisplayService;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public ResponseEntity<ResponseResult> insert(@RequestBody @Valid SoundDisplayDTO soundDisplayDTO, BindingResult bindingResult){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(!bindingResult.hasErrors()) {
				if(soundDisplayService.insert(soundDisplayDTO)) {
					responseResult.setSuccess(true);
					responseResult.setMessage(insertSuccess);
				}else {
					responseResult.setMessage(insertError);
				}
			}else {
				responseResult.setSuccess(false);
				responseResult.setError(bindingResult.getFieldError());
				responseResult.setMessage(messageErrorTotal + bindingResult.getErrorCount());
			}
		} catch (Exception e) {
			responseResult.setSuccess(false);
			responseResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(responseResult);
	} 
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<ResponseResult> update(@RequestBody @Valid SoundDisplayDTO soundDisplayDTO, BindingResult bindingResult){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(!bindingResult.hasErrors()) {
				if(soundDisplayService.update(soundDisplayDTO)) {
					responseResult.setSuccess(true);
					responseResult.setMessage(updateSuccess);
				}else {
					responseResult.setMessage(updateError);
				}
			}else {
				responseResult.setSuccess(false);
				responseResult.setError(bindingResult.getFieldError());
				responseResult.setMessage(messageErrorTotal + bindingResult.getErrorCount());
			}
		} catch (Exception e) {
			responseResult.setSuccess(false);
			responseResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(responseResult);
	} 
	
	@GetMapping("/getById/{id}")
	@ApiOperation(value = "get by id")
	public ResponseEntity<ResponseResult> getById(@PathVariable("id") int id){
		ResponseResult responseResult = new ResponseResult();
		try {
			SoundDisplay soundDisplay = soundDisplayService.getTopById(id);
			if(soundDisplay != null) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(soundDisplay);
			} else {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataNull);
			}
		} catch (Exception e) {
			responseResult.setSuccess(false);
			responseResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(responseResult);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<ResponseResult> getAll(){
		ResponseResult responseResult = new ResponseResult();
		try {
			List<SoundDisplay> soundDisplays = soundDisplayService.getAll();
			if(!soundDisplays.isEmpty()) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(soundDisplays);
			} else {
				responseResult.setMessage(getDataNull);
			}
		} catch (Exception e) {
			responseResult.setSuccess(false);
			responseResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(responseResult);
	}
	
	@GetMapping("/delete/{id}")
	@ApiOperation(value = "delete by id")
	public ResponseEntity<ResponseResult> delete(@PathVariable("id") int id){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(soundDisplayService.delete(id)) {
				responseResult.setSuccess(true);
				responseResult.setMessage(deleteSuccess);
			} else {
				responseResult.setSuccess(true);
				responseResult.setMessage(deleteError);
			}
		} catch (Exception e) {
			responseResult.setSuccess(false);
			responseResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(responseResult);
	}
	
}
