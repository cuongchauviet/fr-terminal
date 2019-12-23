/**
 * 
 */
package com.elcom.gasscale.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.TypeGasTankDTO;
import com.elcom.gasscale.model.ResponseResult;
import com.elcom.gasscale.service.TypeGasTankService;

/**
 * @author cuongcv
 *
 */
@RestController
@RequestMapping("api/type-gas-tank")
public class TypeGasTankController extends GeneralMessage {
	
	private final TypeGasTankService typeGasTankService;
	
	@Autowired
	public TypeGasTankController(TypeGasTankService typeGasTankService) {
		this.typeGasTankService = typeGasTankService;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<ResponseResult> insertTypeGasTank(@RequestBody @Valid TypeGasTankDTO typeGasTankDTO, BindingResult bindingResult){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(!bindingResult.hasErrors()) {
				if(typeGasTankService.insert(typeGasTankDTO)) {
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
	
	@GetMapping("")
	public ResponseEntity<ResponseResult> getTypeGasTankById(long id){
		
		return null;
	}
	
	public ResponseEntity<ResponseResult> getAllTypeGasTankBy(){
		
		return null;
	}
	
}
