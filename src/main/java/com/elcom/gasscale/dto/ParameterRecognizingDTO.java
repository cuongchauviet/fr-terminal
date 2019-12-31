/**
 * 
 */
package com.elcom.gasscale.dto;

import javax.validation.constraints.Digits;
import org.hibernate.validator.constraints.Range;
import com.sun.istack.NotNull;

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
public class ParameterRecognizingDTO {
	
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long id;
	
	@NotNull
	@Range(min = 50, max = 100, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Ngưỡng so sánh BlackList và WhiteList 50 ~ 100", allowableValues = "range[50, 100]", required = true)
	private short faceThreshold;
	
	@Range(min = 0, max = 10, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Chọn loại điều kiện. 0: face opening method, 1: remote door opening mode,  2: remote door opening or face mode.", allowableValues = "range[0, 10]")
	private short opendoorWay;
	
	@Range(min = 0, max = 10, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "điều kiện mở cửa. 1: WhiteLest verification, 2: Id verification, 3: WhiteLest + Id card, 4: WhiteLest or Id card", allowableValues = "range[0, 10]", required = true)
	private short verifyMode;
	
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	@ApiModelProperty(value = "Thời gian reset nhận diện.", allowableValues = "range[0, 9999999999]")
	private int verifyResetTime;
	
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + 10)
	private long createTime;
    
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + 10)
	private long updateTime;
	
}
