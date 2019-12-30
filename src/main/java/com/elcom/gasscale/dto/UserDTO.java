package com.elcom.gasscale.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	@NotBlank
    @Size(min = 3, max = 50, message = "{validate.message.min.max}")
    private String user;
	
	@NotBlank
    @Size(min = 3, max = 50, message = "{validate.message.min.max}")
	private String pwd;
	
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private long createTime;
    
//	@Range(min = 0, max = 10, message = "The update time must be between {min} and {max} characters.") 
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private long updateTime;
	
//	@NotBlank
//    @Size(min = 0, max = 100, message = "{validate.message.min.max}")
//	@ApiModelProperty(value = "role", allowableValues = "ROLE_MEMBER", example = "ROLE_MEMBER, ROLE_ADMIN, ROLE_USER", notes = "Can have multiple role")
//	private String role;
	
	@NotEmpty
	@ApiModelProperty(value = "role", name = "addLines", dataType = "List",
		    example = "[ROLE_MEMBER,ROLE_USER]")
	private List<String> role;
}
