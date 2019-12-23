/**
 * 
 */
package com.elcom.gasscale.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


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
@Table(name = "user_supplier")
public class UserSupplier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 10, nullable = false, unique = true)
	private int id;
	
	@NotBlank
	@Column(name="phone", length = 32, nullable = false, unique = true)
	private String phone;
	
	@NotBlank
	@Column(name="full_name", length = 100, nullable = false)
	private String fullName;
	
	@NotBlank
	@Column(name="address", length = 255)
	private String address;
	
	@NotBlank
	@Column(name="note", length = 1000)
	private String note;
	
	@Column(name="status")
	private short status;
}
