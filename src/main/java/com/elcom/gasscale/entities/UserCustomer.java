/**
 * 
 */
package com.elcom.gasscale.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "user_customer")
public class UserCustomer extends GeneralEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Column(name="phone", length = 32, nullable = false, unique = true)
	private String phone;
	
	@NotBlank
	@Column(name = "full_name", length = 100, nullable = false)
	private String fullName;

}
