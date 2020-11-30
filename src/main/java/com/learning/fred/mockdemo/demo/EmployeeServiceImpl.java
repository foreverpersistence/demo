package com.learning.fred.mockdemo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fred
 * @date 2020/9/22 10:20 上午
 * @description todo
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeReposity;

    @Override
    public Employee find(String name) {
        return employeeReposity.find(name);
    }
}
