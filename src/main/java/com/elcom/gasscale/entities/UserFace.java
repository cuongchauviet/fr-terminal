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
@Table(name = "user_face")
@NoArgsConstructor
@AllArgsConstructor
public class UserFace extends GeneralEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="person_type")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private byte personType;
	
	@Column(name="name", length = 100)
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String name;
	
	@Column(name="gender")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private byte gender;
	
	@Column(name="card_type")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private byte cardType;
	
	@Column(name="id_card", length = 32)
	@Size(min = 0, max = 32, message = "{validate.message.min.max}")
	private String idCard;
	
	@Column(name="birthday")
	@Digits(integer = 10 , fraction = 0, message = "{validate.message.length}" + "10")
	private int birthday;
	
	@Column(name="telnum", length = 32)
	@Size(min = 0, max = 32, message = "{validate.message.min.max}")
	private String telnum;
	
	@Column(name="address", length = 72)
	@Size(min = 0, max = 72, message = "{validate.message.min.max}")
	private String address;
	
	@Column(name="notes", length = 64)
	@Size(min = 0, max = 64, message = "{validate.message.min.max}")
	private String notes;
	
	@Column(name="tempvalid")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private byte tempvalid;
	
	@Column(name="valid_begin", length = 30)
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String validBegin;
	
	@Column(name="valid_end", length = 30)
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String validEnd;
	
	@Column(name="valid_begin_time", length = 30)
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String validBeginTime;
	
	@Column(name="valid_end_time", length = 30)
	@Size(min = 0, max = 30, message = "{validate.message.min.max}")
	private String validEndTime;
	
	@Column(name="picinfo", length = 100)
	@Size(min = 0, max = 100, message = "{validate.message.min.max}")
	private String picinfo;
}
