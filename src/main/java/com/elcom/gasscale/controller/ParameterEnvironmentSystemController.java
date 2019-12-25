/**
 * 
 */
package com.elcom.gasscale.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.ParameterEnvironmentSystemDTO;
import com.elcom.gasscale.entities.ParameterEnvironmentSystem;
import com.elcom.gasscale.model.ResponseResult;
import com.elcom.gasscale.service.ParameterEnvironmentSystemService;

import io.swagger.annotations.ApiOperation;

/**
 * @author cuongcv
 *
 */
@RestController
@RequestMapping("api/parameter-environment-system")
public class ParameterEnvironmentSystemController extends GeneralMessage {
	
	private final ParameterEnvironmentSystemService parameterEnvironmentSystemService;
	
	@Autowired
	public ParameterEnvironmentSystemController(ParameterEnvironmentSystemService parameterEnvironmentSystemService) {
		this.parameterEnvironmentSystemService = parameterEnvironmentSystemService;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	@ApiOperation(value = "insert data")
	public ResponseEntity<ResponseResult> insert(@RequestBody @Valid ParameterEnvironmentSystemDTO parameterEnvironmentSystemDTO, BindingResult bindingResult){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(!bindingResult.hasErrors()) {
				if(parameterEnvironmentSystemService.insert(parameterEnvironmentSystemDTO)) {
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
	@ApiOperation(value = "update data")
	public ResponseEntity<ResponseResult> update(@RequestBody @Valid ParameterEnvironmentSystemDTO parameterEnvironmentSystemDTO, BindingResult bindingResult){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(!bindingResult.hasErrors()) {
				if(parameterEnvironmentSystemService.update(parameterEnvironmentSystemDTO)) {
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
			ParameterEnvironmentSystem parameterEnvironmentSystem = parameterEnvironmentSystemService.getById(id);
			if(parameterEnvironmentSystem != null) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(parameterEnvironmentSystem);
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
	@ApiOperation(value = "get all")
	public ResponseEntity<ResponseResult> getAll(){
		ResponseResult responseResult = new ResponseResult();
		try {
			List<ParameterEnvironmentSystem> parameterEnvironmentSystems = parameterEnvironmentSystemService.getAll();
			if(!parameterEnvironmentSystems.isEmpty()) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(parameterEnvironmentSystems);
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
			if(parameterEnvironmentSystemService.delete(id)) {
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
