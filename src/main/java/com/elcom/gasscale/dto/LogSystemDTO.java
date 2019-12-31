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
public class LogSystemDTO {
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private long id;
	
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	@ApiModelProperty(value = "Thời gian ghi log")
	private long time;
	
	@Range(min = 0, max = 4, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Các thao tác hệ thống tương ứng, thuộc 1 trong 4 loại: 1- Parameter Setting: Các thao tác cập nhật thông số hệ thống như sửa tham số nhận diện, Hiển thị và âm thanh, IP thiết bị, 2- Add List: Thêm mới người trong danh sách. 3- Delete List: Xóa người trong danh sách. 4- Modify List: Sửa người trong danh sách", allowableValues = "range[0, 4]")
	private short dataType;
	
	@Size(min = 0, max = 50, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Log của user nào", example = "admin", required = true)
	private String operation;
	
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	@ApiModelProperty(value = "Các thao tác hệ thống tương ứng: -Add List -Delete List -Modify List	-Modify Machine Name	-Modify IP Address	-Modify Gateway	-Software Start	-Modify Ntp time	-Synchronize Ipc Time	-Modify Center Connection	-Modify the face frame display	-Import Batch Lis	-Parameter Setting")
	private String note;
	
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long createTime;
    
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long updateTime;
}
