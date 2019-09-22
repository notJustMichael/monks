package com.notjustmichael.repository.employee.impl;

import com.notjustmichael.domain.employee.Employee;
import com.notjustmichael.repository.employee.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("EmployeeRepository")

public class EmployeeRepositoryImpl implements EmployeeRepository
{

    private static EmployeeRepositoryImpl repository = null;
    private Set<Employee> employeeSet;
    
    public EmployeeRepositoryImpl()
    {
        this.employeeSet = new HashSet<>();
    }

    private Employee findEmployee(final String phNo)
    {
        return this.employeeSet.stream()
                .filter(employee -> employee.getPhNumber().trim().equals(phNo))
                .findAny()
                .orElse(null);
    }

    public static EmployeeRepositoryImpl getEmployeeRepository()
    {
        if(repository == null)
        {
            repository = new EmployeeRepositoryImpl();
        }

        return repository;
    }

    @Override
    public Set<Employee> getAll() {
        return this.employeeSet;
    }

    @Override
    public Employee create(Employee emp) {
        this.employeeSet.add(emp);
        return emp;
    }

    @Override
    public Employee update(Employee emp) {

        Employee delete = findEmployee(emp.getPhNumber());
        if(delete != null)
        {
            this.employeeSet.remove(delete);
            return create(emp);
        }
        return null;
    }

    @Override
    public void delete(String id)
    {
        Employee emp = findEmployee(id);
        if(emp != null)
        {
            this.employeeSet.remove(emp);
        }
    }

    @Override
    public Employee read(String id)
    {
        Employee emp = findEmployee(id);
        return emp;
    }
}