package com.learning.fred.mockdemo.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

/**
 * @author fred
 * @date 2020/9/22 10:24 上午
 * @description
 */
//https://geek-docs.com/spring/spring-tutorials/springrunner.html
@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {

    /**
     *
     */
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private ApplicationContext context;

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        Employee alex = new Employee("alex");

        Mockito.when(employeeRepository.find(alex.getName()))
                .thenReturn(alex);
    }


    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "alex";
        Employee found = employeeService.find(name);
        Assert.assertTrue(name.equals(found.getName()));
    }

}
