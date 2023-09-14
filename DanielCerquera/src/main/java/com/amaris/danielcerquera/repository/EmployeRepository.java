package com.amaris.danielcerquera.repository;

import com.amaris.danielcerquera.model.Employe;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

    @Modifying
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    @Query("UPDATE Employe u SET u.employee_name = :employee_name, u.employee_salary = :employee_salary, u.employee_age = :employee_age,  u.profile_image = :profile_image WHERE u.id = :id")
    void updateEmployeById(@Param("id") Long id, @Param("employee_name") String employee_name, @Param("employee_salary") Long employee_salary, @Param("employee_age") long employee_age, @Param("profile_image") String profile_image);

}
