/**
 * 
 */
package com.elcom.gasscale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elcom.gasscale.entities.Role;

/**
 * @author cuongcv
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByName(String name);
}
