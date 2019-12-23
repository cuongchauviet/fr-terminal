/**
 * 
 */
package com.elcom.gasscale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elcom.gasscale.entities.UserCustomer;

/**
 * @author cuongcv
 *
 */
@Repository
public interface UserCustomerRepository extends JpaRepository<UserCustomer, Integer> {
	public UserCustomer findByPhone(String phone);
	
	@Query("select u from UserCustomer u where u.status = 0")
	List<UserCustomer> getAll();
	
	@Query("select u from UserCustomer u where u.id = :id and u.status = 0")
	UserCustomer getById(@Param("id") int id);
}
