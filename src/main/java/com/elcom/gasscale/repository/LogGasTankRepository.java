/**
 * 
 */
package com.elcom.gasscale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elcom.gasscale.entities.LogGasTank;

/**
 * @author cuongcv
 *
 */
@Repository
public interface LogGasTankRepository extends JpaRepository<LogGasTank, Integer> {

}
