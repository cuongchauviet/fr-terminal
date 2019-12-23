/**
 * 
 */
package com.elcom.gasscale.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@Table(name = "gas_tank")
public class GasTank extends GeneralEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("id_user")
	private UserCustomer userCustomer;
	
	@NotBlank
	@Column(name = "id_gas_tank", length = 100, nullable = false)
	private String idGasTank;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_type_gas_tank", referencedColumnName="id", nullable = false)
	private TypeGasTank typeGasTank;
	
	@NotNull
	@Column(name = "residual_gas_tank",nullable = false)
	@Digits(integer = 5 , fraction = 1)
	private float residualGasTank;
	
	@NotNull
	@Column(name = "residual_battery", nullable = false)
	@Range(min = 0, max = 100, message = "{validate.message.min.max}") 
	private int residualBattery;
	
	@NotNull
	@Column(name = "replate_time", nullable = false)
	@Digits(integer = 10 , fraction = 0)
	private int replateTime;
	
}
