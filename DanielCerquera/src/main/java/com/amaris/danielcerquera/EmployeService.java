package com.amaris.danielcerquera;

import java.util.List;
import java.util.Optional;
import com.amaris.danielcerquera.model.Employe;
import com.amaris.danielcerquera.model.EmployeeBusiness;
import org.springframework.stereotype.Component;
import com.amaris.danielcerquera.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Component
public class EmployeService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    public EmployeService(EmployeeBusiness employeeBusiness) {
        this.employeeBusiness = employeeBusiness;
    }

    private EmployeeBusiness employeeBusiness;

    public long calculateAndStoreAnnualSalary(Employe employee) {
        return employeeBusiness.calculateAndStoreAnnualSalary(employee.getId());
    }

    public Employe createEmploye(Employe user){
        if (user.getId() != null){
            employeeBusiness.calculateAndStoreAnnualSalary(user.getId());
        }
        return employeRepository.save(user);
    }

    public Employe getEmployeById(Long id){
        employeeBusiness.calculateAndStoreAnnualSalary(id);
        Optional<Employe> optionalUser = employeRepository.findById(id);
        return optionalUser.get();
    }

    public List<Employe> getAllEmployees(){
        return employeRepository.findAll();
    }

    public void deleteEmploye(Long id){
        employeRepository.deleteById(id);
    }

    public void updateEmploye(Long id, String employee_name, Long employee_salary, Long employee_age, String profile_image) {
        employeRepository.updateEmployeById(id, employee_name, employee_salary, employee_age,profile_image);
    }

}
