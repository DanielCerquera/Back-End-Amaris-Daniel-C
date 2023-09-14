package com.amaris.danielcerquera.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amaris.danielcerquera.repository.EmployeRepository;
import com.amaris.danielcerquera.model.Employe;

@Service
public class EmployeeBusiness {
    private EmployeRepository employeRepository;

    @Autowired
    public EmployeeBusiness(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public long calculateAndStoreAnnualSalary(Long employeeId) {

        Employe employe = employeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + employeeId));
        long annualSalary = employe.getEmployee_salary() * 12;
        employe.setEmployee_anual_salary(annualSalary);
        employeRepository.save(employe);
        return annualSalary;
    }
}

