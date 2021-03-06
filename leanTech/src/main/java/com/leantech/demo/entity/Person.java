package com.leantech.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;  
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jgarzon
 */
@Entity
@Table
public class Person {
    
@Id
@Column
private Integer id;

@Column  
private String name;  

@Column  
private String lastName;  

@Column  
private String address;

@Column  
private String cellphone;  

@Column  
private String cityName;  

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


}
