/**
 * 
 */
package com.elcom.gasscale.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public class UserSupplierDTO {
	
	@NotBlank
    @Size(min = 10, max = 10, message = "{validate.message.min.max}")
	@Pattern(regexp="(^$|[0-9]{10})", message = "{validate.message.number}")
    private String phone;
	
	@NotBlank
    @Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String fullName;
	
    @Size(min = 0, max = 255, message = "{validate.message.min.max}")
	private String address;
	
    @Size(min = 0, max = 1000, message = "{validate.message.min.max}")
	private String note;
    
    @Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private long userSupplierId;
}
