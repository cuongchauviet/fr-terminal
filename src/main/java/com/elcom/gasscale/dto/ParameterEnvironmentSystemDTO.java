/**
 * 
 */
package com.elcom.gasscale.dto;

import javax.validation.constraints.Digits;
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
public class ParameterEnvironmentSystemDTO {
	
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long id;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Chọn ngôn ngữ. 0: Tiếng việt, 1: Tiếng Anh", allowableValues = "range[0, 2]")
	private short language;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Ghi lại hồ sơ. 0: Không ghi lại, 1: Ghi lại", allowableValues = "range[0, 2]")
	private short recordCapture;
	
	@Range(min = 0, max = 3, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Hành vi khi phát hiện người. 0: Open the door, 1: Checkin, 2: Open the door and checkin ,3: Other", allowableValues = "range[0, 3]")
	private short enableHumanDetect;
	
	@Range(min = 0, max = 100, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Ngưỡng phát hiện người (tính theo 0%-100%)", allowableValues = "range[0, 100]")
	private short humamThreshold;
	
	@Range(min = 0, max = 9, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Số người cùng lúc trong khung hình", allowableValues = "range[0, 9]")
	private short humanFrameNumber;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Bật led. 0: Never, 1: alway", allowableValues = "range[0, 2]")
	private short enableLed;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Màn hình hiển thị. 0: Tắt khi không có người, 1: Luôn luôn bật", allowableValues = "range[0, 2]")
	private short screenDisplayType;
	
	@Digits(integer = 5, fraction = 0, message = "{validate.message.length}" + "5")
	@ApiModelProperty(value = "Tắt màn hình khi không có người sau khoảng thời gian (seconds)", allowableValues = "range[0, 99999]")
	private short disableScreen;
	
	@Range(min = 0, max = 960, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Pixel khuôn mặt nhỏ nhất: Nhập Pixel khuôn mặt nhỏ nhất mà hệ thống có thể nhận diện được(0~960px)", allowableValues = "range[0, 960]")
	private short faceMinPixel;
	
	@Range(min = 0, max = 960, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Vùng phát hiện khuôn mặt trục X (0~960px)", allowableValues = "range[0, 960]")
	private short faceAreaX;
	
	@Range(min = 0, max = 1280, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Vùng phát hiện khuôn mặt trục Y(0 ~ 1280 pixel).", allowableValues = "range[0, 1280]")
	private short faceAreaY;
	
	@Range(min = 0, max = 960, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Chiều rộng vùng phát hiện khôn mặt (0~960 pixel)", allowableValues = "range[0, 960]")
	private short faceAreaWidth;
	
	@Range(min = 0, max = 1280, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Chiều dài vùng phát hiện khôn mặt (0~1280 pixel)", allowableValues = "range[0, 1280]")
	private short faceAreaHeight;
	
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + 10)
	private long createTime;
    
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + 10)
	private long updateTime;
}
