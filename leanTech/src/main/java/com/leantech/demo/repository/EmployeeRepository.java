package com.leantech.demo.repository;

import com.leantech.demo.entity.Employee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;  

/**
 *
 * @author jgarzon
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
