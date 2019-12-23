/**
 * 
 */
package com.elcom.gasscale.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author cuongcv
 *
 */
@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "config_device")
public class ConfigDevice extends GeneralEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column(name = "warning_percent_gas", length = 3, nullable = false)
	@Max(value = 100, message = "{validate.message.max}" + "100")
	@Min(value = 0, message = "{validate.message.min}" + "0")
	private short warningPercentGas;

	@NotNull
	@Column(name = "warning_percent_battery", length = 3, nullable = false)
	@Max(value = 100, message = "{validate.message.max}" + "100")
	@Min(value = 0, message = "{validate.message.min}" + "0")
	private short warningPercentBattery;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(nullable = false, name = "id_type_gas_tank")
	private TypeGasTank typeGasTank;
	
}
