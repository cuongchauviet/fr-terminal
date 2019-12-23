/**
 * 
 */
package com.elcom.gasscale.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.config.JwtTokenUtil;
import com.elcom.gasscale.dto.LoginDTO;
import com.elcom.gasscale.dto.UserDTO;
import com.elcom.gasscale.entities.User;
import com.elcom.gasscale.model.ResponseResult;
import com.elcom.gasscale.service.UserService;
import com.elcom.gasscale.service.impl.JwtUserDetailsService;

/**
 * @author cuongcv
 *
 */
@RestController
@RequestMapping("api/user")
public class UserController extends GeneralMessage {
	
	private final UserService userService;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<ResponseResult> getById(@PathVariable("id") int id){
		ResponseResult responseResult = new ResponseResult();
		try {
			User user = userService.getUserById(id);
			if(user != null) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(user);
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
			List<User> user = userService.getAllUser();
			if(!user.isEmpty()) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(user);
			} else {
				responseResult.setMessage(getDataNull);
			}
		} catch (Exception e) {
			responseResult.setSuccess(false);
			responseResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(responseResult);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseResult> login(@RequestBody @Valid LoginDTO loginDTO, BindingResult bindingResult){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(!bindingResult.hasErrors()) {
				jwtTokenUtil.authenticate(loginDTO.getPhone(), loginDTO.getPwd());
				final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getPhone());
				final String token = jwtTokenUtil.generateToken(userDetails);
				responseResult.setSuccess(true);
				responseResult.setData(token);
				responseResult.setMessage("success");
			}else {
				responseResult.setMessage(messageErrorTotal + bindingResult.getErrorCount());
				responseResult.setError(bindingResult.getFieldError());
			}
		} catch (Exception e) {
			responseResult.setMessage(e.getMessage());
			responseResult.setError(e);
		}
		return ResponseEntity.ok(responseResult);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public ResponseEntity<ResponseResult> insert(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult){
		ResponseResult responseResult = new ResponseResult();
		try {
			if(!bindingResult.hasErrors()) {
				if(userService.insertUser(userDTO)) {
					responseResult.setSuccess(true);
					responseResult.setMessage(insertSuccess);
				} else {
					responseResult.setMessage(insertError);
				}
				responseResult.setData(null);
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
}
