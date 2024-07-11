package com.te.jpql.project.controller;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.te.jpql.project.dto.EmployeeDTO;
import com.te.jpql.project.entity.Employee;
import com.te.jpql.project.response.SuccessResponse;
import com.te.jpql.project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class CustormerController {
	private final EmployeeService employeeService;
	@GetMapping("/get-employee")
	public ResponseEntity<SuccessResponse> getEmployee() {
		return ResponseEntity.ofNullable(SuccessResponse.builder()
				.data(Employee.builder().employeeAdd("Benglore").employeeAge("22").employeeBloodGroup("B+")
						.employeeName("pranav").employeeDob("25").employeeCilty("korba").employeeId(1).build())
				.message("this is woirkign").dateTime(LocalDateTime.now())
				.httpStatus(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).build());
	}
	@PostMapping("/post-employee")
	public ResponseEntity<SuccessResponse> createEmployee(@RequestBody EmployeeDTO employeedto) {
		String s = employeeService.save(employeedto);
		return ResponseEntity.ofNullable(SuccessResponse.builder().data(s).message("create")
				.dateTime(LocalDateTime.now()).httpStatus(HttpStatus.OK).build());
	}

	// find by dynamic value
	@PostMapping("/find")
	public ResponseEntity<SuccessResponse> createEmployee(@RequestParam String... employee) {
		List<EmployeeDTO> s = employeeService.findByNameWithDynamicType(employee);
		return ResponseEntity.ofNullable(SuccessResponse.builder().data(s).message("create")
				.dateTime(LocalDateTime.now()).httpStatus(HttpStatus.OK).build());
	}
	// pagination
	@GetMapping("/get-page")
	public ResponseEntity<SuccessResponse> getPagees(
			@RequestParam(value = "pageNumber", defaultValue = "10", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "1", required = false) Integer pageSize) {
		List<EmployeeDTO> s = employeeService.findByNameWithDynamicType(pageNumber, pageSize);
		return ResponseEntity.ofNullable(SuccessResponse.builder().data(s).message("create")
				.dateTime(LocalDateTime.now()).httpStatus(HttpStatus.OK).build());
	}
}