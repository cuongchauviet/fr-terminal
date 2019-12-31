/**
 * 
 */
package com.elcom.gasscale.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

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
public class TimeSystemDTO {
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long id;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Bật giao thức đồng bộ thời gian npt. 0: Không bật, 1: Bật", allowableValues = "range[0, 2]")
	private short ntpEnable;
	
	@Size(min = 0, max = 255, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "npt server ip address")
	private String ntpUrl;
	
	@Digits(integer = 4, fraction = 0, message = "{validate.message.length}" + "4")
	@ApiModelProperty(value = "ntp server PORT", allowableValues = "range[0, 9999]")
	private short nptPort;
	
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	@ApiModelProperty(value = "Time zone")
	private int nptTimeZone;
	
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	@ApiModelProperty(value = "Khoảng thời gian hiệu chỉnh(giờ)")
	private int nptIntervar;
	
	@Range(min = 1900, max = 9999, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Năm", allowableValues = "range[1900, 9999]")
	private short year;
	
	@Range(min = 1, max = 12, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Tháng", allowableValues = "range[1, 12]")
	private short month;
	
	@Range(min = 1, max = 31, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "ngày", allowableValues = "range[1, 31]")
	private short day;
	
	@Range(min = 0, max = 23, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Giờ", allowableValues = "range[0, 23]")
	private short hour;
	
	@Range(min = 0, max = 59, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Phút", allowableValues = "range[0, 59]")
	private short minute;
	
	@Range(min = 0, max = 59, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "giây", allowableValues = "range[0, 59]")
	private short second;
	
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long createTime;
    
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long updateTime;
}
