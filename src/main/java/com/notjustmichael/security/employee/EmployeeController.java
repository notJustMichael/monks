package com.notjustmichael.security.employee;

import com.notjustmichael.domain.employee.Employee;
import com.notjustmichael.domain.ResponseObj;
import com.notjustmichael.domain.request.NewEmployee;
import com.notjustmichael.factory.employee.EmployeeFactory;
import com.notjustmichael.factory.ResponseObjFactory;
import com.notjustmichael.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/monks/employee")
public class EmployeeController {
    @Autowired
    @Qualifier("EmployeeServiceImpl")

    private EmployeeService service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createEmployee(@RequestBody NewEmployee employee) {
        System.out.println(employee);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Employee created!");
        if (employee.getFirstName() == null || employee.getLastName() == null) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Please provide first and/or last name!");
        } else {
            Employee savedEmp = saveEmployee(employee);
            responseObj.setResponse(savedEmp);
        }
        return ResponseEntity.ok(responseObj);
    }

    private Employee saveEmployee(NewEmployee employee) {
        Employee emp = EmployeeFactory.buildEmployee(employee.getPhoneNumber(), employee.getFirstName(), employee.getLastName());
        return service.create(emp);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Employee> employees = service.getAll();
        responseObj.setResponse(employees);
        return ResponseEntity.ok(responseObj);
    }

}
