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

import com.elcom.gasscale.entities.User;

/**
 * @author cuongcv
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.user = :user and u.status = 0")
	User findByUser(@Param("user") String user);
	
	@Query("select u from User u where u.user = :user and u.status = 0")
	Optional<User> getByUser(String user);
	
	@Query("select u from User u where u.status = 0")
	List<User> getAll();
	
}
