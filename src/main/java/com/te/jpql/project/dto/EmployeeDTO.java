package com.te.jpql.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class EmployeeDTO {

	private String employeeName;
	private String employeeAge;
	private String employeeDob;
	private String employeeBloodGroup;
	private String employeeAdd;
	private String employeeCilty;

}
