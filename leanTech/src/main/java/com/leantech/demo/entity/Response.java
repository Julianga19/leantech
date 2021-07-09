/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leantech.demo.entity;

import java.util.List;

/**
 *
 * @author jgarzon
 */
public class Response {
    
    Integer id;
    
    String name;
            
    List<EmployeeResponse> employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeResponse> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeeResponse> employee) {
        this.employee = employee;
    }

}
