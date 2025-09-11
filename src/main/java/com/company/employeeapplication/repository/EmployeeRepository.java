package com.company.employeeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.employeeapplication.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query("select e.name from Employee e where e.salary = :salary")
//    List<String> getNamesBySalary(@Param("salary") long salary);


    @Query(value = "SELECT e.name FROM employee e WHERE e.salary = :salary", nativeQuery = true)
    List<String> getNamesBySalary(@Param("salary") long salary);



}
