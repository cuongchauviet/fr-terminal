/**
 * 
 */
package com.elcom.gasscale.dto;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
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
public class SoundDisplayDTO {
	
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long id;
	
	@NotNull
	@Range(min = 0, max = 10, message = "{validate.message.min.max}")
	private short verifySuccAudio;
	
	@NotNull
	@Range(min = 0, max = 10, message = "{validate.message.min.max}")
	private short verifyFailAudio;
	
	@NotNull
	@Range(min = 0, max = 100, message = "{validate.message.min.max}")
	private short volume;
	
	@NotNull
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short verifySuccGuiTip;
	
	@NotNull
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short verifyFailGuiTip;
	
	@NotNull
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short ipDevice;
	
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long createTime;
    
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long updateTime;
}
