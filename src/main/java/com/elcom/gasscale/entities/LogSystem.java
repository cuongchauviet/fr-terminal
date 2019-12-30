/**
 * 
 */
package com.elcom.gasscale.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

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
@Table(name = "log_system")
public class LogSystem extends GeneralEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "time")
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private int time;
	
	@Column(name="data_type")
	@Range(min = 0, max = 4, message = "{validate.message.min.max}")
	private byte dataType;
	
	@Column(name = "operation", length = 50)
	@Size(min = 0, max = 50, message = "{validate.message.min.max}")
	private String operation;
	
	@Column(name = "note", length = 100)
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String note;
}
