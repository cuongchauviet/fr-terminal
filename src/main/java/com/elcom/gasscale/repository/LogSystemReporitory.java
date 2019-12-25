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

import com.elcom.gasscale.entities.LogSystem;

/**
 * @author cuongcv
 *
 */
@Repository
public interface LogSystemReporitory extends JpaRepository<LogSystem, Integer> {
	@Query("select s from LogSystem s where s.id = :id and s.status = 0")
	LogSystem findById(@Param("id") int id);
	
	@Query("select s from LogSystem s where s.status = 0")
	List<LogSystem> getAll();
	
	@Query("select s from LogSystem s where s.id = :id and s.status = 0")
	Optional<LogSystem> getById(@Param("id") int id);
}
