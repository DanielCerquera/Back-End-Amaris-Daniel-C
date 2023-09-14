package com.amaris.danielcerquera.controller;

import com.amaris.danielcerquera.EmployeService;
import com.amaris.danielcerquera.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/employe")
public class EmployeController {

    @Autowired
    private EmployeService employeService;
    @PostMapping
    public Employe createEmploye(@RequestBody Employe employe){
        return employeService.createEmploye(employe);
    }
    @GetMapping
    public List<Employe> getAllEmployees(){
        return employeService.getAllEmployees();
    }
    @GetMapping("{id}")
    public Employe findEmployeById(@PathVariable("id") Long id){
        return employeService.getEmployeById(id);
    }
    @DeleteMapping("{id}")
    public void deleteEmployeById(@PathVariable("id") Long id){
        employeService.deleteEmploye(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public void updateEmployeById(@PathVariable("id") Long id, @RequestBody Employe employe) {
        employeService.updateEmploye(id, employe.getEmployee_name(), employe.getEmployee_salary(), employe.getEmployee_age(), employe.getProfile_image());
    }

}
