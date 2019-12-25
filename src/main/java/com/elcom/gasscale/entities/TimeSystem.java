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
@Table(name = "time_system")
@NoArgsConstructor
@AllArgsConstructor
public class TimeSystem extends GeneralEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ntp_enable")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short ntpEnable;
	
	@Size(min = 0, max = 255, message = "{validate.message.min.max}")
	@Column(name = "ntp_url", length = 255)
	private String ntpUrl;
	
	@Column(name = "npt_port")
	@Digits(integer = 4, fraction = 0, message = "{validate.message.length}" + "4")
	private short nptPort;
	
	@Column(name = "npt_time_zone")
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private int nptTimeZone;
	
	@Column(name = "npt_intervar")
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private int nptIntervar;
	
	@Column(name = "year")
	@Range(min = 1900, max = 9999, message = "{validate.message.min.max}")
	private short year;
	
	@Column(name = "month")
	@Range(min = 1, max = 12, message = "{validate.message.min.max}")
	private short month;
	
	@Column(name = "day")
	@Range(min = 1, max = 31, message = "{validate.message.min.max}")
	private short day;
	
	@Column(name = "hour")
	@Range(min = 0, max = 23, message = "{validate.message.min.max}")
	private short hour;
	
	@Column(name = "minute")
	@Range(min = 0, max = 59, message = "{validate.message.min.max}")
	private short minute;
	
	@Column(name = "second")
	@Range(min = 0, max = 59, message = "{validate.message.min.max}")
	private short second;
}
