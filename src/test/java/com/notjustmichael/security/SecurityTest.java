package com.notjustmichael.security;

//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
import com.notjustmichael.domain.request.NewEmployee;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class SecurityTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/monks/employee";


    @Test
    public void getEmployees() {
        NewEmployee emp = new NewEmployee();
        emp.setFirstName("Michael");
        emp.setLastName("Thomas");
        emp.setPhoneNumber("19216881");
        ResponseEntity result = restTemplate.withBasicAuth("Andrew","88181")
                .getForEntity(baseURL+"/getall/",String.class);
        //.postForEntity(baseURL+"/create/",emp, String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
    @Test
    public void createEmployee_fail() {
        NewEmployee emp = new NewEmployee();
        emp.setFirstName("Michael");
        emp.setLastName("Thomas");
        emp.setPhoneNumber("19216881");
        ResponseEntity result = restTemplate.withBasicAuth("Michael","99797")
                .postForEntity(baseURL+"/create/",emp,String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.FORBIDDEN, result.getStatusCode());
    }
    @Test
    public void createEmployee_pass() {
        NewEmployee emp = new NewEmployee();
        emp.setFirstName("Michael");
        emp.setLastName("Thomas");
        emp.setPhoneNumber("19216881");
        ResponseEntity result = restTemplate.withBasicAuth("Andrew","88181")
                .postForEntity(baseURL+"/create/",emp,String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
    @Test
    public void getEmployee_fail_incorrect_password() {
        NewEmployee emp = new NewEmployee();
        emp.setFirstName("Michael");
        emp.setLastName("Thomas");
        emp.setPhoneNumber("19216881");
        ResponseEntity result = restTemplate.withBasicAuth("Andrew","881818")
                .getForEntity(baseURL+"/getall/",String.class);
        //.postForEntity(baseURL+"/create/",emp, String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }
}
