package com.notjustmichael.domain.employee;

public class Employee {
    private String phNumber, lName, fName;

    private Employee(){}

    public Employee(EmployeeBuilder empBuilder) {
        this.phNumber = empBuilder.phoneNumber;
        this.fName = empBuilder.firstName;
        this.lName = empBuilder.lastName;

    }

    public String getPhNumber() {
        return phNumber;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public static class EmployeeBuilder{
        private String phoneNumber, firstName, lastName;

        public EmployeeBuilder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public EmployeeBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder copy(Employee employee){
            this.firstName = employee.fName;
            this.lastName = employee.lName;
            this.phoneNumber = employee.phNumber;

            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

    }
}
