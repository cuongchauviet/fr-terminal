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

import com.elcom.gasscale.entities.UserFace;

/**
 * @author cuongcv
 *
 */
@Repository
public interface UserFaceRepository extends JpaRepository<UserFace, Integer> {
	@Query("select s from UserFace s where s.id = :id and s.status = 0")
	UserFace findById(@Param("id") int id);
	
	@Query("select s from UserFace s where s.status = 0")
	List<UserFace> getAll();
	
	@Query("select s from UserFace s where s.id = :id and s.status = 0")
	Optional<UserFace> getById(@Param("id") int id);
}
