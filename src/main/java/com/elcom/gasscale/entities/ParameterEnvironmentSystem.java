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
@Table(name = "parameter_environment_system")
public class ParameterEnvironmentSystem extends GeneralEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "language")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short language;
	
	@Column(name = "record_capture")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short recordCapture;
	
	@Column(name = "enable_human_detect")
	@Range(min = 0, max = 3, message = "{validate.message.min.max}")
	private short enableHumanDetect;
	
	@Column(name = "humam_threshold")
	@Range(min = 0, max = 100, message = "{validate.message.min.max}")
	private short humamThreshold;
	
	@Column(name = "human_frame_number")
	@Range(min = 0, max = 9, message = "{validate.message.min.max}")
	private short humanFrameNumber;
	
	@Column(name = "enable_led")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short enableLed;
	
	@Column(name = "screen_display_type")
	@Range(min = 0, max = 2, message = "{validate.message.min.max}")
	private short screenDisplayType;
	
	@Column(name = "disable_screen")
	@Digits(integer = 5, fraction = 0, message = "{validate.message.length}" + "5")
	private short disableScreen;
	
	@Column(name = "face_min_pixel")
	@Range(min = 0, max = 960, message = "{validate.message.min.max}")
	private short faceMinPixel;
	
	@Column(name = "face_area_x")
	@Range(min = 0, max = 960, message = "{validate.message.min.max}")
	private short faceAreaX;
	
	@Column(name = "face_area_y")
	@Range(min = 0, max = 1280, message = "{validate.message.min.max}")
	private short faceAreaY;
	
	@Column(name = "face_area_width")
	@Range(min = 0, max = 960, message = "{validate.message.min.max}")
	private short faceAreaWidth;
	
	@Column(name = "face_area_height")
	@Range(min = 0, max = 1280, message = "{validate.message.min.max}")
	private short faceAreaHeight;
}
