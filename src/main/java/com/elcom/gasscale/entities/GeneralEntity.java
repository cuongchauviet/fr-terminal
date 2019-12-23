/**
 * 
 */
package com.elcom.gasscale.entities;


import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * @author cuongcv
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class GeneralEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 10)
	private int id;
	
	@Column(name = "create_time", length = 10, nullable = false)
	private int createTime;
	
	@Column(name = "update_time", length = 10, nullable = false)
	private int updateTime;
	
	@Column(name = "status", length = 1)
	private short status; 
}
