package com.leantech.demo.repository;

import com.leantech.demo.entity.Person;
import org.springframework.data.repository.CrudRepository;  

/**
 *
 * @author jgarzon
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
