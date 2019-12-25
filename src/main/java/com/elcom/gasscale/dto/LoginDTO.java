/**
 * 
 */
package com.elcom.gasscale.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cuongcv
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
	
	@NotBlank
	@Size(min = 3, max = 50, message = "{validate.message.min.max}")
	private String user;
	
	@NotBlank
	@Size(min = 3, max = 50, message = "{validate.message.min.max}")
	private String pwd;
}
