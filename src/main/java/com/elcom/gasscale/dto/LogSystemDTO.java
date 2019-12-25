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
public class LogSystemDTO {
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long id;
	
	@Size(min = 0, max = 32, message = "{validate.message.min.max}")
	private String time;
	
	@Range(min = 0, max = 4, message = "{validate.message.min.max}")
	private short dataType;
	
	@Size(min = 0, max = 50, message = "{validate.message.min.max}")
	private String operation;
	
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String note;
	
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long createTime;
    
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long updateTime;
}
