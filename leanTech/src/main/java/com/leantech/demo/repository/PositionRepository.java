package com.leantech.demo.repository;

import com.leantech.demo.entity.Position;
import org.springframework.data.repository.CrudRepository;  

/**
 *
 * @author jgarzon
 */
public interface PositionRepository extends CrudRepository<Position, Integer> {

}
