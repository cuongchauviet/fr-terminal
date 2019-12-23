/**
 * 
 */
package com.elcom.gasscale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elcom.gasscale.entities.TypeGasTank;

/**
 * @author cuongcv
 *
 */
@Repository
public interface TypeGasTankRepository extends JpaRepository<TypeGasTank, Integer> {
	
	@Query("select g from TypeGasTank g where g.id = :id and g.status = 0")
	TypeGasTank getById(@Param("id") int id);
}
