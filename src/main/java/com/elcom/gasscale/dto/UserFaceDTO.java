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
public class UserFaceDTO {
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long id;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "List type. 0: white list, 1: black list", allowableValues = "range[0, 2]")
	private short personType;
	
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Họ Và Tên", required = true)
	private String name;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Giới tính. 0: male, 1: female", allowableValues = "range[0, 2]")
	private short gender;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Loại thẻ. 0: ID card", allowableValues = "range[0, 2]")
	private short cardType;
	
	@Size(min = 0, max = 32, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "id number, tối đa 32 ký tự", required = true)
	private String idCard;
	
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	@ApiModelProperty(value = "Ngày sinh")
	private long birthday;
	
	@Size(min = 0, max = 32, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "phone number, tối đa 32 ký tự")
	private String telnum;
	
	@Size(min = 0, max = 72, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Địa chỉ tối đa 72 ký tự")
	private String address;
	
	@Size(min = 0, max = 64, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Remarks tối đa 64 ký tự")
	private String notes;
	
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Các kiểu danh sách. 0: permanent list(Không thời hạn), 1: Temporary list 1 ( Trong khoảng từ ngày,giờ - ngày,giờ), 2: Temporary list 2 (Trong khoảng thời gian từ ngày - đến ngày, trong một ngày có thể đặt trong khoảng giờ)", allowableValues = "range[0, 2]")
	private short tempvalid;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Nếu Kiểu danh sách  temporary list 1, cho chọn ngày và giờ(2018-03 12T09:09:20). Nếu kiểu danh sách là temporary list 2, cho chọn ngày (2018-03-12)")
	private String validBegin;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Nếu Kiểu danh sách  temporary list 1, cho chọn ngày, giờ (2018-03-12T09:10:00). Nếu kiểu danh sách là temporary list 2: cho chọn ngày ( 2018-03-12)")
	private String validEnd;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Nếu kiểu danh sách là temporary list 2, chọn giờ bắt đầu trong 1 ngày")
	private String validBeginTime;
	
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Nếu kiểu danh sách là temporary list 2, chọn giờ kết thúc trong 1 ngày")
	private String validEndTime;
	
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Thông tin ảnh khuôn mặt")
	private String picinfo;
	
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long createTime;
    
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long updateTime;
}
