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
public class UserFaceDTO {
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long id;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short personType;
	
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String name;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short gender;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short cardType;
	
	@Size(min = 0, max = 32, message = "{validate.message.min.max}")
	private String idCard;
	
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long birthday;
	
	@Size(min = 0, max = 32, message = "{validate.message.min.max}")
	private String telnum;
	
	@Size(min = 0, max = 72, message = "{validate.message.min.max}")
	private String address;
	
	@Size(min = 0, max = 64, message = "{validate.message.min.max}")
	private String notes;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short tempvalid;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String validBegin;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String validEnd;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String validBeginTime;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String validEndTime;
	
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String picinfo;
	
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long createTime;
    
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long updateTime;
}
