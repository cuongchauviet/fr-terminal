package com.elcom.gasscale.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	@NotBlank
    @Size(min = 10, max = 10, message = "{validate.message.min.max}")
	@Pattern(regexp="(^$|[0-9]{10})", message = "{validate.message.number}")
    private String phone;
	
	@NotBlank
    @Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String fullName;
	
	@NotBlank
    @Size(min = 3, max = 50, message = "{validate.message.min.max}")
	private String pwd;
	
	@Digits(integer = 10, message = "{validate.message.length}" + "10", fraction = 0)
	private long createTime;
    
//	@Range(min = 0, max = 10, message = "The update time must be between {min} and {max} characters.") 
	@Digits(integer = 10, message = "{validate.message.length}" + "10", fraction = 0)
	private long updateTime;
	
	@NotBlank
    @Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String role;
}
