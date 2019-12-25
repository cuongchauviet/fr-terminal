/**
 * 
 */
package com.elcom.gasscale.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Range;

import com.sun.istack.NotNull;

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
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parameter_recognizing")
public class ParameterRecognizing extends GeneralEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column(name="face_threshold")
	@Range(min = 50, max = 100, message = "{validate.message.min.max}")
	private byte faceThreshold;
	
	@Column(name="opendoor_way")
	@Range(min = 0, max = 10, message = "{validate.message.min.max}")
	private byte opendoorWay;
	
	@Column(name="verify_mode")
	@Range(min = 0, max = 10, message = "{validate.message.min.max}")
	private byte verifyMode;
	
	@Column(name="verify_reset_time")
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private int verifyResetTime;
	
}
