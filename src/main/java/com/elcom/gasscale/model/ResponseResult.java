/**
 * 
 */
package com.elcom.gasscale.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author cuongcv
 *
 */
@Data
@AllArgsConstructor
public class ResponseResult {
	
	private Boolean success;
	
	private String message;
	
	private Object error;
	
	private Object data;

	public ResponseResult() {
		this.success = false;
		this.message = "";
		this.error = null;
		this.data = null;
	}
}
