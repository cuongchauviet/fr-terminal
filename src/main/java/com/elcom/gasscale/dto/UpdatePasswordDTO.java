/**
 * 
 */
package com.elcom.gasscale.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "Tên user đăng nhập", required = true)
    private String user;
	
	@NotBlank
    @Size(min = 3, max = 50, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Password cũ", required = true)
	private String pwdOld;
	
	@NotBlank
    @Size(min = 3, max = 50, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Password mới", required = true)
	private String pwdNew;
	
	@NotBlank
    @Size(min = 3, max = 50, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Password confirm", required = true)
	private String confirmPwd;
	
	public boolean matchNewAndConfirmPassword() {
		return this.getPwdNew().equals(this.getConfirmPwd());
	}
}
