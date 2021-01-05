package com.learning.fred.design.principle.struct.compose;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fred
 * @date 2020/12/23 11:40
 * @description todo
 */
public class Department extends HumanResource {

    private List<HumanResource> subNodes = new ArrayList<>();


    public Department(long id) {
        super(id);
    }

    @Override
    public double caculateSalary() {
        double totalSaray = 0;
        for (HumanResource hr : subNodes) {
            totalSaray += hr.caculateSalary();
        }
        this.salary = totalSaray;
        return totalSaray;
    }

    public void addSubNode(HumanResource hr) {
        subNodes.add(hr);
    }

}
