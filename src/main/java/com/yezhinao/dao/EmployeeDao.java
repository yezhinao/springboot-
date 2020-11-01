package com.yezhinao.dao;


import com.yezhinao.pojo.Department;
import com.yezhinao.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employeeMap;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employeeMap = new HashMap<Integer, Employee>();

        employeeMap.put(10001,new Employee(10001,"A1","A123456@qq.com",0,new Department(1001,"策划部"),new Date()));
        employeeMap.put(10002,new Employee(10002,"B2","B123456@qq.com",0,new Department(1002,"信息部"),new Date()));
        employeeMap.put(10003,new Employee(10003,"C3","C123456@qq.com",0,new Department(1003,"外联部"),new Date()));
        employeeMap.put(10004,new Employee(10004,"D4","D123456@qq.com",0,new Department(1004,"志愿部"),new Date()));
        employeeMap.put(10005,new Employee(10005,"E5","E123456@qq.com",0,new Department(1005,"调研部"),new Date()));
    }

    //主键自增
    private static Integer initId = 10006;

    /**
     * 插入一个员工数据
     * @param employee 员工对象
     */
    public void save(Employee employee){
        if(employee.getEId() == null){
            employee.setEId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getDepId()));

        employeeMap.put(employee.getEId(),employee);

    }

    /**
     * 查找所有的员工
     * @return
     */
    public Collection<Employee> getAll(){
        return employeeMap.values();
    }

    /**
     * 通过id查找员工
     * @param id
     * @return
     */
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    /**
     * 删除一个员工
     * @param id
     */
    public void deleteOne(Integer id){
        employeeMap.remove(id);
    }
}
