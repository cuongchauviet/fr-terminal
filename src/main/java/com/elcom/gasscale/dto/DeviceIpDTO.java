package com.elcom.gasscale.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceIpDTO {
	
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long id;
	
	@NotNull
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private long deviceId;
	
	@NotBlank
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String version;
	
	
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private long buildTime;
	
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String title;
	
	@NotBlank
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String ipAddress;
	
	@NotBlank
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String submask;
	
	@NotBlank
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String gateway;
	
	
	@NotNull
	@Digits(integer = 4, fraction = 0, message = "{validate.message.length}" + "4")
	private short webPort;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String dns1;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String dns2;
	
	@Digits(integer = 10, message = "{validate.message.length}" + "10", fraction = 0)
	private long createTime;
    
	@Digits(integer = 10, message = "{validate.message.length}" + "10", fraction = 0)
	private long updateTime;
	
}
