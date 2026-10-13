package com.hairain.service;

import com.hairain.pojo.Dept;

import java.util.List;

/**
 * ClassName:DeptService
 * Package: com.hairain.service
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/5 16:09
 * @Version 1.0
 */
public interface DeptService {

    //查询部门数据
    List<Dept> findAll();

    void deleteById(Integer id) throws Exception;

    void insertName(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
