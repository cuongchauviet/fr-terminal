package com.elcom.gasscale.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "Id thiết bị, không cấu hình")
	private long deviceId;
	
	@NotBlank
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Version thiết bị, không cấu hình")
	private String version;
	
	
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	@ApiModelProperty(value = "Thời gian build thiết bị, không cấu hình")
	private long buildTime;
	
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Tiêu đề")
	private String title;
	
	@NotBlank
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Địa chỉ ip của thiết bị")
	private String ipAddress;
	
	@NotBlank
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Subnet mask")
	private String submask;
	
	@NotBlank
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "geteway")
	private String gateway;
	
	
	@NotNull
	@Digits(integer = 4, fraction = 0, message = "{validate.message.length}" + "4")
	@ApiModelProperty(value = "web service port")
	private short webPort;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "dns1")
	private String dns1;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "dns2")
	private String dns2;
	
	@Digits(integer = 10, message = "{validate.message.length}" + "10", fraction = 0)
	@ApiModelProperty(value = "Ngày tạo")
	private long createTime;
    
	@Digits(integer = 10, message = "{validate.message.length}" + "10", fraction = 0)
	@ApiModelProperty(value = "Ngày update")
	private long updateTime;
}
