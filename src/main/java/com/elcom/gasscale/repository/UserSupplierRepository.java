/**
 * 
 */
package com.elcom.gasscale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elcom.gasscale.entities.UserSupplier;

/**
 * @author cuongcv
 *
 */
@Repository
public interface UserSupplierRepository extends JpaRepository<UserSupplier, Integer> {
	
	@Query("select p from UserSupplier p where p.status = 0")
	List<UserSupplier> getAllByStatusIsZero();
	
	UserSupplier findByPhone(String phone);
	
	@Query("select p from UserSupplier p where p.id = :id and p.status = 0")
	UserSupplier getById(@Param("id") int id);
}
