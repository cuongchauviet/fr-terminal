/**
 * 
 */
package com.elcom.gasscale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.entities.UserCustomer;
import com.elcom.gasscale.model.ResponseResult;
import com.elcom.gasscale.service.UserCustomerService;

/**
 * @author cuongcv
 *
 */
@RestController
@RequestMapping("api/user-customer")
public class UserCustomerController extends GeneralMessage {
	
	private final UserCustomerService userCustomerService;
	
	@Autowired
	public UserCustomerController(UserCustomerService userCustomerService) {
		this.userCustomerService = userCustomerService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<ResponseResult> getAll(){
		ResponseResult responseResult = new ResponseResult();
		try {
			List<UserCustomer> userCustomer = userCustomerService.getAllUser();
			if(!userCustomer.isEmpty()) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(userCustomer);
			} else {
				responseResult.setMessage(getDataNull);
			}
		} catch (Exception e) {
			responseResult.setSuccess(false);
			responseResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(responseResult);
	}
	
}
