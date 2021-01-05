package com.learning.fred.design.principle.struct.compose;

import java.util.List;

/**
 * @author fred
 * @date 2020/12/23 11:43
 * @description todo
 */
public class Demo {

    private static final long ORGANIZATION_ROOT_ID = 1001;
    // dao
//    private DepartmentRepo departmentRepo; // 依赖注入
//    private EmployeeRepo employeeRepo; // 依赖注入


    public void buildOrganization() {
        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(rootDepartment);
    }


    private void buildOrganization(Department department) {
        List<Long> subDepartmentIds = null;//获取 部门下面的字部分
        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment = new Department(subDepartmentId);
            department.addSubNode(subDepartment);
            buildOrganization(subDepartment);
        }

        List<Long> employeeIds = null;//
        for (Long employeeId : employeeIds) {

            double salary = 0;//员工salary
            department.addSubNode(new Employee(employeeId, salary));
        }
    }


}
