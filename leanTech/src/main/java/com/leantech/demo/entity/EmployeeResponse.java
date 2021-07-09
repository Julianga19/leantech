package com.leantech.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;  
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author jgarzon
 */

public class EmployeeResponse {
    

private Integer id;

private Integer salary;

private Person person;  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


}
