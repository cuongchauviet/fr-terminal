/**
 * 
 */
package com.elcom.gasscale.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author cuongcv
 *
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "type_gas_tank")
public class TypeGasTank extends GeneralEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column(name="name_gas_tank", length = 100, nullable = false)
	private String nameGasTank;
	
	@NotNull
	@Column(name = "weight_crust_gas_tank", nullable = false)
	@Digits(integer = 5 , fraction = 1)
	private float weightCrustGasTank;
	
	@NotNull
	@Column(name = "weight_insides_gas_tank", nullable = false)
	@Digits(integer = 5 , fraction = 1)
	private float weightInsidesGasTank;
}
