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
import com.elcom.gasscale.dto.LogSystemDTO;
import com.elcom.gasscale.entities.LogSystem;
import com.elcom.gasscale.model.ResponseResult;
import com.elcom.gasscale.service.LogSystemService;

import io.swagger.annotations.ApiOperation;

/**
 * @author cuongcv
 *
 */
@RestController
@RequestMapping("api/log-system")
@CrossOrigin
public class LogSystemController extends GeneralMessage {

	private final LogSystemService logSystemService;
	
	@Autowired
	public LogSystemController(LogSystemService logSystemService) {
		this.logSystemService = logSystemService;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public ResponseEntity<ResponseResult> insert(@RequestBody @Valid LogSystemDTO logSystemDTO, BindingResult bindingResult){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(!bindingResult.hasErrors()) {
				if(logSystemService.insert(logSystemDTO)) {
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
	public ResponseEntity<ResponseResult> update(@RequestBody @Valid LogSystemDTO logSystemDTO, BindingResult bindingResult){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(!bindingResult.hasErrors()) {
				if(logSystemService.update(logSystemDTO)) {
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
			LogSystem logSystem = logSystemService.getById(id);
			if(logSystem != null) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(logSystem);
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
			List<LogSystem> logSystems = logSystemService.getAll();
			if(!logSystems.isEmpty()) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(logSystems);
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
			logSystemService.delete(id);
			responseResult.setSuccess(true);
			responseResult.setMessage(deleteSuccess);
		} catch (Exception e) {
			responseResult.setSuccess(false);
			responseResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(responseResult);
	}

}
