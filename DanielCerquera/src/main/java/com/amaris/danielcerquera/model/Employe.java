package com.amaris.danielcerquera.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "employees")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employee_name;
    private Long employee_salary;
    private Long employee_age;
    private String profile_image;

    private Long employee_anual_salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Long getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Long employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Long getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Long employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public Long getEmployee_anual_salary() {
        return employee_anual_salary;
    }

    public void setEmployee_anual_salary(Long employee_anual_salary) {
        this.employee_anual_salary = employee_anual_salary;
    }



}

