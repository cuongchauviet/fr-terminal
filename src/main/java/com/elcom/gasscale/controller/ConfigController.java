/**
 * 
 */
package com.elcom.gasscale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.gasscale.config.GeneralMessage;
import com.elcom.gasscale.model.MdlConfigDevice;
import com.elcom.gasscale.model.ResponseResult;
import com.elcom.gasscale.service.ConfigDeviceService;

/**
 * @author cuongcv
 *
 */
@RestController
@RequestMapping("api/config")
public class ConfigController extends GeneralMessage {
	
	private final ConfigDeviceService configDeviceService;
	
	
	@Autowired
	public ConfigController(ConfigDeviceService configDeviceService) {
		this.configDeviceService = configDeviceService;
	}
	
	@GetMapping("getConfig")
	public ResponseEntity<ResponseResult> getConfig() {
		ResponseResult responseResult = new  ResponseResult();
		try {
			MdlConfigDevice mdlConfigDevice = configDeviceService.getTopConfig();
			if(mdlConfigDevice != null) {
				responseResult.setSuccess(true);
				responseResult.setMessage(getDataSuccess);
				responseResult.setData(mdlConfigDevice);
			}else {
				responseResult.setMessage(getDataError);
			}
		} catch (Exception e) {
			responseResult.setError(e);
			responseResult.setMessage(e.getMessage());
		}
		return ResponseEntity.ok(responseResult);
	}
}
