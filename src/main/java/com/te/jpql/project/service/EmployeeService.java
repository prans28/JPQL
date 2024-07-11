package com.te.jpql.project.service;

import java.util.List;

import com.te.jpql.project.dto.EmployeeDTO;

public interface EmployeeService {

	String save(EmployeeDTO employeedto);

	List<EmployeeDTO> findByNameWithDynamicType(String[] employee);

	List<EmployeeDTO> findByNameWithDynamicType(Integer pageNumber, Integer pageSize);

}
