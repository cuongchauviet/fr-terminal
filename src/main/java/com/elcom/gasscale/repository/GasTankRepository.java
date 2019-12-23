/**
 * 
 */
package com.elcom.gasscale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elcom.gasscale.entities.GasTank;

/**
 * @author cuongcv
 *
 */
@Repository
public interface GasTankRepository extends JpaRepository<GasTank, Integer> {
	
	@Query("select g from GasTank g where g.id = :id and g.status = 0")
	GasTank getById(@Param("id") int id);
	
	@Query("select g from GasTank g where g.status = 0")
	List<GasTank> getAll();
	
}
