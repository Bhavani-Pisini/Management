package com.employee.Management.repository;

import com.employee.Management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) = LOWER(:Ename)") //JPQL
    List<Employee> findByName(@Param("Ename") String name);
    /*
    @Query(value = "SELECT * FROM employee WHERE LOWER(name) = LOWER(:Ename)", nativeQuery = true)
    List<Employee> findByName(@Param("Ename") String name);
    */
}
