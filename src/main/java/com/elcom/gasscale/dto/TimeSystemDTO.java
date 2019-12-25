/**
 * 
 */
package com.elcom.gasscale.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

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
	private short ntpEnable;
	
	@Size(min = 0, max = 255, message = "{validate.message.min.max}")
	private String ntpUrl;
	
	@Digits(integer = 4, fraction = 0, message = "{validate.message.length}" + "4")
	private short nptPort;
	
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private int nptTimeZone;
	
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private int nptIntervar;
	
	@Range(min = 1900, max = 9999, message = "{validate.message.min.max}")
	private short year;
	
	@Range(min = 1, max = 12, message = "{validate.message.min.max}")
	private short month;
	
	@Range(min = 1, max = 31, message = "{validate.message.min.max}")
	private short day;
	
	@Range(min = 0, max = 23, message = "{validate.message.min.max}")
	private short hour;
	
	@Range(min = 0, max = 59, message = "{validate.message.min.max}")
	private short minute;
	
	@Range(min = 0, max = 59, message = "{validate.message.min.max}")
	private short second;
	
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long createTime;
    
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long updateTime;
}
