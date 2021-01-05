package com.learning.fred.design.principle.struct.compose;

/**
 * @author fred
 * @date 2020/12/23 11:39
 * @description todo
 */
public class Employee extends HumanResource {

    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double caculateSalary() {
        return salary;
    }
}
