/**
 * 
 */
package com.elcom.gasscale.dto;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
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
public class SoundDisplayDTO {
	
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long id;
	
	@NotNull
	@Range(min = 0, max = 10, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Khi xác thực thành công. 0: Không phát âm thanh thông báo, 1: Phát âm thanh thông báo", allowableValues = "range[0, 10]")
	private short verifySuccAudio;
	
	@NotNull
	@Range(min = 0, max = 10, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Khi xác thực thất bại. 0: Không phát âm thanh thông báo, 1: Phát âm thanh thông báo", allowableValues = "range[0, 10]")
	private short verifyFailAudio;
	
	@NotNull
	@Range(min = 0, max = 100, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Mức âm lượng", allowableValues = "range[0, 100]")
	private short volume;
	
	@NotNull
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Thông báo xác thực thành công. 0: Không hiển thị, 1: Hiển thị", allowableValues = "range[0, 2]")
	private short verifySuccGuiTip;
	
	@NotNull
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Thông báo xác thực thất bại. 0: Không hiển thị, 1: Hiển thị", allowableValues = "range[0, 2]")
	private short verifyFailGuiTip;
	
	@NotNull
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Hiển thị IP thiết bị. 0: Không hiển thị. 1: Hiển thị", allowableValues = "range[0, 2]")
	private short ipDevice;
	
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long createTime;
    
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long updateTime;
}
