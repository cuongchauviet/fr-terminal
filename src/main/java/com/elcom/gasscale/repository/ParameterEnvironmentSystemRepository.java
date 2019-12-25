/**
 * 
 */
package com.elcom.gasscale.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elcom.gasscale.entities.ParameterEnvironmentSystem;

/**
 * @author cuongcv
 *
 */
@Repository
public interface ParameterEnvironmentSystemRepository extends JpaRepository<ParameterEnvironmentSystem, Integer> {
	
	@Query("select s from ParameterEnvironmentSystem s where s.id = :id and s.status = 0")
	ParameterEnvironmentSystem findById(@Param("id") int id);
	
	@Query("select s from ParameterEnvironmentSystem s where s.status = 0")
	List<ParameterEnvironmentSystem> getAll();
	
	@Query("select s from ParameterEnvironmentSystem s where s.id = :id and s.status = 0")
	Optional<ParameterEnvironmentSystem> getById(@Param("id") int id);
}
