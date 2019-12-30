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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.dto.UserFaceDTO;
import com.elcom.gasscale.entities.UserFace;
import com.elcom.gasscale.logic.PageableEnum;
import com.elcom.gasscale.model.ResponseResult;
import com.elcom.gasscale.service.UserFaceService;

import io.swagger.annotations.ApiOperation;

/**
 * @author cuongcv
 *
 */
@RestController
@RequestMapping("api/user-face")
@CrossOrigin
public class UserFaceController extends GeneralMessage {
	
	private final UserFaceService userFaceService;
	
	@Autowired
	public UserFaceController(UserFaceService userFaceService) {
		this.userFaceService = userFaceService;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	@ApiOperation(value = "insert data")
	public ResponseEntity<ResponseResult> insert(@RequestBody @Valid UserFaceDTO userFaceDTO, BindingResult bindingResult){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(!bindingResult.hasErrors()) {
				if(userFaceService.insert(userFaceDTO)) {
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
	public ResponseEntity<ResponseResult> update(@RequestBody @Valid UserFaceDTO userFaceDTO, BindingResult bindingResult){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(!bindingResult.hasErrors()) {
				if(userFaceService.update(userFaceDTO)) {
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
			UserFace userFace = userFaceService.getById(id);
			if(userFace != null) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(userFace);
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
	public ResponseEntity<ResponseResult> getAll(
			@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize,
			@RequestParam(value = "sortCol", required = false, defaultValue = PageableEnum.CREATE_TIME) String sortCol,
            @RequestParam(value = "sortDirect", required = false, defaultValue = PageableEnum.ASC) String sortDirect
			){
		ResponseResult responseResult = new ResponseResult();
		try {
			List<UserFace> userFaces = userFaceService.getAll(pageNumber, pageSize, sortCol, sortDirect);
			if(!userFaces.isEmpty()) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(userFaces);
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
			if(userFaceService.delete(id)) {
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
