package com.te.jpql.project.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.te.jpql.project.dto.EmployeeDTO;
import com.te.jpql.project.entity.Employee;
import com.te.jpql.project.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ImplEmployeeService implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	@Override
	public String save(EmployeeDTO employeedto) {
		return employeeRepository.save(Employee.builder().employeeAdd(employeedto.getEmployeeAdd())
				.employeeAge(employeedto.getEmployeeAge()).employeeBloodGroup(employeedto.getEmployeeBloodGroup())
				.employeeDob(employeedto.getEmployeeDob()).employeeCilty(employeedto.getEmployeeCilty())
				.employeeAge(employeedto.getEmployeeAge()).employeeName(employeedto.getEmployeeName()).build())
				.getEmployeeName();
	}
	@Override
	public List<EmployeeDTO> findByNameWithDynamicType(String[] employee) {
		List<String> asList = Arrays.asList(employee);
		List<Employee> emp = employeeRepository.findByDynamicValue(asList);
		return emp.stream()
				.map(e -> EmployeeDTO.builder().employeeAdd(e.getEmployeeAdd()).employeeAge(e.getEmployeeAge())
						.employeeBloodGroup(e.getEmployeeBloodGroup()).employeeCilty(e.getEmployeeCilty())
						.employeeName(e.getEmployeeName()).employeeBloodGroup(e.getEmployeeBloodGroup())
						.employeeDob(e.getEmployeeDob()).build())
				.collect(Collectors.toList());
	}
	@Override
	public List<EmployeeDTO> findByNameWithDynamicType(Integer pageNumber, Integer pageSize) {
		Page<Employee> all = employeeRepository.findAll( PageRequest.of(pageNumber, pageSize));
		return all.stream()
				.map(e -> EmployeeDTO.builder().employeeAdd(e.getEmployeeAdd()).employeeAge(e.getEmployeeAge())
						.employeeBloodGroup(e.getEmployeeBloodGroup()).employeeDob(e.getEmployeeDob())
						.employeeName(e.getEmployeeName()).build())
				.collect(Collectors.toList());
	}

}