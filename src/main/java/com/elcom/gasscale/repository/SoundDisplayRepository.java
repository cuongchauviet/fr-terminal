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

import com.elcom.gasscale.entities.SoundDisplay;

/**
 * @author cuongcv
 *
 */
@Repository
public interface SoundDisplayRepository extends JpaRepository<SoundDisplay, Integer> {
	
	@Query("select s from SoundDisplay s where s.id = :id and s.status = 0")
	SoundDisplay findById(@Param("id") int id);
	
	@Query("select s from SoundDisplay s where s.status = 0")
	List<SoundDisplay> getAll();
	
	@Query("select s from SoundDisplay s where s.id = :id and s.status = 0")
	Optional<SoundDisplay> getById(@Param("id") int id);
}
