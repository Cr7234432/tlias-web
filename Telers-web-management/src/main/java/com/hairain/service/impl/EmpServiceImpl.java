package com.hairain.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hairain.mapper.EmpExprMapper;
import com.hairain.mapper.EmpMapper;
import com.hairain.pojo.*;
import com.hairain.service.EmpLogService;
import com.hairain.service.EmpService;
import com.hairain.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * ClassName:EmpServiceImpl
 * Package: com.hairain.service.impl
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/6 17:12
 * @Version 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;


    @Override
    public PageResult<Emp> find(EmpQueryParam empQueryParam) {
//        Long total = empMapper.count();
//        Integer start = (page-1)*pageSize;
//        List<Emp> rows = empMapper.list(start,pageSize);
//        return new PageResult<>(total,rows);
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> empList = empMapper.list(empQueryParam);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(),p.getResult());
    }


    @Transactional(rollbackFor = {Exception.class})//事务管理
    @Override
    public void save(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.inserts(exprList);
            }
        } finally {
            //记录操作日志
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"新增员工:"+emp);
            empLogService.insertLog(empLog);
        }

    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getInfo(id);
    }


    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.inserts(exprList);
        }
    }

    @Override
    public List<Emp> findAll() {
        return empMapper.findAll();
    }

    @Override
    public LogInfo login(Emp emp) {
        Emp user = empMapper.findByPassandUser(emp);
        if(user!=null){
            Map<String,Object> dataMap = new HashMap<>();
            dataMap.put("id",user.getId());
            dataMap.put("username",user.getUsername());
            String jwt = JWTUtils.productJWT(dataMap);
            LogInfo logInfo = new LogInfo(user.getId(),user.getUsername(),user.getName(),jwt);
            return logInfo;
        }
        return null;
    }


}
