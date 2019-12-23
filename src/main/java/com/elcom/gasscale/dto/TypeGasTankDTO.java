/**
 * 
 */
package com.elcom.gasscale.dto;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class TypeGasTankDTO {
	@NotBlank
    @Size(min = 0, max = 100, message = "{validate.message.min.max}")
    private String nameGasTank;
	
	@NotNull
	@Digits(integer = 5, fraction = 1, message = "{validate.message.length}" + "5")
	private float weightCrustGasTank;
	
	@NotNull
	@Digits(integer = 5, fraction = 1, message = "{validate.message.length}" + "5")
	private float weightInsidesGasTank;
	
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long createTime;
    
	@Digits(integer = 10, message = "{validate.message.length}" + 10, fraction = 0)
	private long updateTime;
}
