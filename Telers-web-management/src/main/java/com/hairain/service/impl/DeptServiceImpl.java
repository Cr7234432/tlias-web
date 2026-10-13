package com.hairain.service.impl;

import com.hairain.mapper.DeptMapper;
import com.hairain.mapper.EmpMapper;
import com.hairain.pojo.Dept;
import com.hairain.pojo.Emp;
import com.hairain.pojo.Result;
import com.hairain.service.DeptService;
import com.hairain.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:DeptServiceImpl
 * Package: com.hairain.service.impl
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/5 16:10
 * @Version 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) throws IllegalStateException {

        List<Emp> emp = empMapper.findByDeptId(id);
        if(CollectionUtils.isEmpty(emp)) {
            deptMapper.delete(id);
        }
        else throw new IllegalStateException("部门下有员工，无法删除");
    }

    @Override
    public void insertName(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insertName(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
