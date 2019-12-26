/**
 * 
 */
package com.elcom.gasscale.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name = "sound_display")
public class SoundDisplay extends GeneralEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column(name="verify_succ_audio")
	@Range(min = 0, max = 10, message = "{validate.message.min.max}")
	private byte verifySuccAudio;
	
	@NotNull
	@Column(name="verify_fail_audio")
	@Range(min = 0, max = 10, message = "{validate.message.min.max}")
	private byte verifyFailAudio;
	
	@NotNull
	@Column(name="volume")
	@Range(min = 0, max = 100, message = "{validate.message.min.max}")
	private byte volume;
	
	@NotNull
	@Column(name="verify_succ_gui_tip")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private byte verifySuccGuiTip;
	
	@NotNull
	@Column(name="verify_fail_gui_tip")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private byte verifyFailGuiTip;
	
	@NotNull
	@Column(name="ip_device")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private byte ipDevice;
	
}
