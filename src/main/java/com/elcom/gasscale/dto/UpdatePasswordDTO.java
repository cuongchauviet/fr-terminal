/**
 * 
 */
package com.elcom.gasscale.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "Update password Request", description = "The update password request payload")
public class UpdatePasswordDTO {
	
	@NotBlank
    @Size(min = 3, max = 50, message = "{validate.message.min.max}")
    private String user;
	
	@NotBlank
    @Size(min = 3, max = 50, message = "{validate.message.min.max}")
	private String pwdOld;
	
	@NotBlank
    @Size(min = 3, max = 50, message = "{validate.message.min.max}")
	private String pwdNew;
	
	@NotBlank
    @Size(min = 3, max = 50, message = "{validate.message.min.max}")
	private String confirmPwd;
	
	public boolean matchNewAndConfirmPassword() {
		return this.getPwdNew().equals(this.getConfirmPwd());
	}
}
