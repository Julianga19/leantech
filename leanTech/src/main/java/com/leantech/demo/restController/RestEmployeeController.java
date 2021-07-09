package com.leantech.demo.restController;

import com.leantech.demo.entity.Employee;
import com.leantech.demo.entity.Response;
import com.leantech.demo.repository.EmployeeRepository;
import com.leantech.demo.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jgarzona
 */
@RestController
public class RestEmployeeController {

    @Autowired  
    private EmployeeService employeeService;

    @RequestMapping("/employee/get")        
    public List<Response> getEmployees(){        
      return employeeService.convertResult(employeeService.getEmployees());
    }
    
    @RequestMapping("/employee/get/{param}")        
    public List<Response> getEmployees(@PathVariable("param") String param){
        List<Employee> employees = new ArrayList<>();
        List<Employee> result = new ArrayList<>();                
        employees.stream()
                .filter(e -> param.equals(e.getPosition().getName()) || 
                        param.equals(e.getPerson().getName()))
                .forEach(result :: add);
        return employeeService.convertResult(result);
    }

    @RequestMapping("/employee/create")            
    public void saveEmployee(@RequestBody Employee empl){
        employeeService.save(empl);
    }
    
    @RequestMapping("/employee/update")            
    public void updateEmployee(@RequestBody Employee empl){
        employeeService.save(empl);
    }
    
    @RequestMapping("/employee/delete/{id}")    
    public void deleteEmployee(@PathVariable("id") Integer id){
        employeeService.delete(id);
    }
}
