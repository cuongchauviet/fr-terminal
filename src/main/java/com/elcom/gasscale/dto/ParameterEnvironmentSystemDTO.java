/**
 * 
 */
package com.elcom.gasscale.dto;

import javax.validation.constraints.Digits;
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
public class ParameterEnvironmentSystemDTO {
	
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long id;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short language;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short recordCapture;
	
	@Range(min = 0, max = 3, message = "{validate.message.min.max}")
	private short enableHumanDetect;
	
	@Range(min = 0, max = 100, message = "{validate.message.min.max}")
	private short humamThreshold;
	
	@Range(min = 0, max = 9, message = "{validate.message.min.max}")
	private short humanFrameNumber;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short enableLed;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short screenDisplayType;
	
	@Digits(integer = 5, fraction = 0, message = "{validate.message.length}" + "5")
	private short disableScreen;
	
	@Range(min = 0, max = 960, message = "{validate.message.min.max}")
	private short faceMinPixel;
	
	@Range(min = 0, max = 960, message = "{validate.message.min.max}")
	private short faceAreaX;
	
	@Range(min = 0, max = 1280, message = "{validate.message.min.max}")
	private short faceAreaY;
	
	@Range(min = 0, max = 960, message = "{validate.message.min.max}")
	private short faceAreaWidth;
	
	@Range(min = 0, max = 1280, message = "{validate.message.min.max}")
	private short faceAreaHeight;
	
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + 10)
	private long createTime;
    
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + 10)
	private long updateTime;
}
