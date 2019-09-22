package com.notjustmichael.domain.request;

public class NewEmployee {

    private String phNo, firstName, lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phNo;
    }

    public void setPhoneNumber(String phNo) {
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        return "NewEmployee{" +
                "phoneNumber='" + phNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
