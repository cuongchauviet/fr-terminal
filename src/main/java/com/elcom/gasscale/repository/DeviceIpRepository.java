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

import com.elcom.gasscale.entities.DeviceIp;

/**
 * @author cuongcv
 *
 */
@Repository
public interface DeviceIpRepository extends JpaRepository<DeviceIp, Integer> {
	@Query("select s from DeviceIp s where s.id = :id and s.status = 0")
	DeviceIp findById(@Param("id") int id);
	
	@Query("select s from DeviceIp s where s.status = 0")
	List<DeviceIp> getAll();
	
	@Query("select s from DeviceIp s where s.id = :id and s.status = 0")
	Optional<DeviceIp> getById(@Param("id") int id);
}
