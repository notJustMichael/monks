package com.notjustmichael.service.employee.impl;

import com.notjustmichael.domain.employee.Employee;
import com.notjustmichael.repository.employee.EmployeeRepository;
import com.notjustmichael.repository.employee.impl.EmployeeRepositoryImpl;
import com.notjustmichael.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    @Qualifier("EmployeeRepository")

    private EmployeeRepository employeeRepository;
    private static EmployeeService employeeService = null;

    private EmployeeServiceImpl() {
        this.employeeRepository = EmployeeRepositoryImpl.getEmployeeRepository();
    }

    public static EmployeeService getEmployeeService() {
        if (employeeService == null) employeeService = new EmployeeServiceImpl();
        return employeeService;
    }

    @Override
    public Employee create(Employee d) {
        return this.employeeRepository.create(d);
    }

    @Override
    public Employee read(String s) {
        return this.employeeRepository.read(s);
    }

    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.update(employee);
    }

    @Override
    public void delete(String s) {
        this.employeeRepository.delete(s);
    }

    @Override
    public Set<Employee> getAll() {
        return this.employeeRepository.getAll();
    }
}
