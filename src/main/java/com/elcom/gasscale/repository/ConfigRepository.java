/**
 * 
 */
package com.elcom.gasscale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elcom.gasscale.entities.ConfigDevice;

/**
 * @author cuongcv
 *
 */
@Repository
public interface ConfigRepository extends JpaRepository<ConfigDevice, Integer> {
	
}
