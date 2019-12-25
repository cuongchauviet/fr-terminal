/**
 * 
 */
package com.elcom.gasscale.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name = "device_ip")
public class DeviceIp extends GeneralEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name="device_id")
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private int deviceId;
	
	@NotBlank
	@Column(name="version", length = 100, nullable = false, unique = true)
	private String version;
	
	@Column(name="build_time")
	@Digits(integer = 10, fraction = 0, message = "{validate.message.length}" + "10")
	private int buildTime;
	
	@Column(name = "title", length = 100)
	private String title;
	
	@NotBlank
	@Column(name="ip_address")
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String ipAddress;
	
	@NotBlank
	@Column(name="submask")
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String submask;
	
	@NotBlank
	@Column(name="gateway")
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String gateway;
	
	
	@NotNull
	@Column(name="web_port")
	@Digits(integer = 4, fraction = 0, message = "{validate.message.length}" + "4")
	private short webPort;
	
	@Column(name="dns1")
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String dns1;
	
	@Column(name="dns2")
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String dns2;
}
