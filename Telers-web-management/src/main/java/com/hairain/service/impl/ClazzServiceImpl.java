package com.hairain.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hairain.exception.ClazzException;
import com.hairain.mapper.ClazzMapper;
import com.hairain.mapper.StudentMapper;
import com.hairain.pojo.*;
import com.hairain.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:ClazzServiceImpl
 * Package: com.hairain.service.impl
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/9 12:17
 * @Version 1.0
 */
@Service
public class ClazzServiceImpl implements ClazzService{

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam) {

        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());

        List<Clazz> list =  clazzMapper.findAll(clazzQueryParam);
        Page<Clazz> p = (Page<Clazz>) list;

        return new PageResult<>(p.getTotal(),list);
    }

    @Override
    public void delete(Integer id) {
        List<Student> list = studentMapper.findByClazz(id);
        if(CollectionUtils.isEmpty(list)) {
            clazzMapper.delete(id);
        }
        else throw new ClazzException("该班级下有学生，无法删除");
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.save(clazz);
    }

    @Override
    public Clazz findById(Integer id) {
        return clazzMapper.findById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> findAlll() {
        return clazzMapper.findAlll();
    }


}
