/**
 * 
 */
package com.elcom.gasscale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elcom.gasscale.entities.ParameterRecognizing;

/**
 * @author cuongcv
 *
 */
@Repository
public interface ParameterRecognizingRepository extends JpaRepository<ParameterRecognizing, Integer> {
	
	@Query("select p from ParameterRecognizing p where p.status = 0")
	List<ParameterRecognizing> getAllByStatusIsZero();
	
	@Query("select p from ParameterRecognizing p where p.id = :id and p.status = 0")
	ParameterRecognizing getById(@Param("id") int id);
}
