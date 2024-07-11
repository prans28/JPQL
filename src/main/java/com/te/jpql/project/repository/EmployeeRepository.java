package com.te.jpql.project.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.te.jpql.project.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select m from Employee m where m.employeeId in :employee")
	List<Employee> findByDynamicValue(@Param("employee") List<String> employee);


}
