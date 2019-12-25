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

import com.elcom.gasscale.entities.TimeSystem;

/**
 * @author cuongcv
 *
 */
@Repository
public interface TimeSystemRepository extends JpaRepository<TimeSystem, Integer> {
	@Query("select s from TimeSystem s where s.id = :id and s.status = 0")
	TimeSystem findById(@Param("id") int id);
	
	@Query("select s from TimeSystem s where s.status = 0")
	List<TimeSystem> getAll();
	
	@Query("select s from TimeSystem s where s.id = :id and s.status = 0")
	Optional<TimeSystem> getById(@Param("id") int id);
}
