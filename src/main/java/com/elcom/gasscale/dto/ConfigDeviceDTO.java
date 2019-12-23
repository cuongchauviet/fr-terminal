/**
 * 
 */
package com.elcom.gasscale.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
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
public class ConfigDeviceDTO {
	
	@NotNull
	@Range(min = 0, max = 100, message = "{validate.message.min.max}") 
    private short warningPercentGas;
	
	@NotNull
	@Range(min = 0, max = 100, message = "{validate.message.min.max}") 
    private short warningPercentBattery;
	
	@NotNull
	@Digits(integer = 10, message = "{validate.message.length}" + "10", fraction = 0)
	@Min(value = 1, message = "{validate.message.min}" + "0")
    private long idTypeGasTank;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Digits(integer = 10, message = "{validate.message.length}" + "10", fraction = 0)
	private long updateTime;
}
