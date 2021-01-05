package com.learning.fred.design.principle.struct.compose;

/**
 * @author fred
 * @date 2020/12/23 11:38
 * @description todo
 */
public abstract class HumanResource {
    protected  long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public abstract double caculateSalary();
}
