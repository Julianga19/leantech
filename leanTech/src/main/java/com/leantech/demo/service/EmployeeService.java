package com.leantech.demo.service;

import com.leantech.demo.entity.Employee;
import com.leantech.demo.entity.EmployeeResponse;
import com.leantech.demo.entity.Response;
import com.leantech.demo.repository.EmployeeRepository;
import com.leantech.demo.repository.PersonRepository;
import com.leantech.demo.repository.PositionRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgarzona
 */
@Service
public class EmployeeService {

    @Autowired  
    EmployeeRepository employeeRepository;      
    @Autowired  
    PersonRepository personRepository;      
    @Autowired  
    PositionRepository positionRepository;      
    
    Map<String,String> positions = new HashMap<String, String>();

    public List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList();
        employeeRepository.findAll().forEach(employees :: add);        
        return employees;
    }

    public List<Response> convertResult(List<Employee> employees){
        List<Response> result = new ArrayList();
        List<Employee> sortedList = employees.stream()
            .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
            .collect(Collectors.toList());        
        for(Employee emp: sortedList){
            if(result.isEmpty() || !positions.containsKey(emp.getPosition().getName())){
                result.add(this.createResponse(emp));
            } else{
                result.forEach(res -> {
                if(res.getName().equals(emp.getPosition().getName())){
                    res.getEmployee().add(convertEmployee(emp));
                } 
                });
            }
        }
        return result;
    }
    
    private Response createResponse(Employee emp){
        Response r = new Response();
        r.setId(emp.getPosition().getId());
        r.setName(emp.getPosition().getName());
        positions.put(r.getName(),r.getName());
        List<EmployeeResponse> rl = new ArrayList();
        rl.add(convertEmployee(emp));
        r.setEmployee(rl);
        return r;
    }
    
    private EmployeeResponse convertEmployee(Employee emp){
        EmployeeResponse re = new EmployeeResponse();
        re.setId(emp.getId());
        re.setSalary(emp.getSalary());
        re.setPerson(emp.getPerson());        
        return re;
    }

    public void save(Employee empl){
        positionRepository.save(empl.getPosition());
        personRepository.save(empl.getPerson());
        employeeRepository.save(empl);
    }
    
    public void delete(Integer id){
        employeeRepository.deleteById(id);
    }
}
