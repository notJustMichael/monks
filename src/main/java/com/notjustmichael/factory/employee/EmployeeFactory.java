package com.notjustmichael.factory.employee;


import com.notjustmichael.domain.employee.Employee;

public class EmployeeFactory {

        public static Employee buildEmployee(String phNo, String fN, String lN) {
            return new Employee.EmployeeBuilder()
                    .phoneNumber(phNo)
                    .firstName(fN)
                    .lastName(lN)
                    .build();
        }
    }

