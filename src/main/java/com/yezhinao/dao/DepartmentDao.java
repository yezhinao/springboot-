package com.yezhinao.dao;


import com.yezhinao.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departmentMap = null;

    static {
        departmentMap = new HashMap<Integer, Department>();

        departmentMap.put(1001,new Department(1001,"策划部"));
        departmentMap.put(1002,new Department(1002,"信息部"));
        departmentMap.put(1003,new Department(1003,"外联部"));
        departmentMap.put(1004,new Department(1004,"志愿部"));
        departmentMap.put(1005,new Department(1005,"调研部"));
    }

    /**
     * 获取所有部门
     * @return
     */
    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }


    /**
     * 通过id获取部门
     * @param id 部门id
     * @return
     */
    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }


}
