package com.hairain.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hairain.mapper.StudentMapper;
import com.hairain.pojo.PageResult;
import com.hairain.pojo.StuQueryParam;
import com.hairain.pojo.Student;
import com.hairain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:StudentServiceImpl
 * Package: com.hairain.service.impl
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/9 15:02
 * @Version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> list(StuQueryParam stuQueryParam) {

        PageHelper.startPage(stuQueryParam.getPage(),stuQueryParam.getPageSize());
        List<Student> list = studentMapper.list(stuQueryParam);
        Page<Student> page = (Page<Student>)list;
        return  new PageResult<>(page.getTotal(),list);
    }

    @Override
    public void delete(Integer id) {
        studentMapper.delete(id);
    }

    @Override
    public void insert(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void punish(Integer id, Short score) {
        Student student = studentMapper.findById(id);
        student.setUpdateTime(LocalDateTime.now());
        Short i = student.getViolationCount();
        if(i==null) i=1;
        else i++;
        student.setViolationCount(i);
        Short cur = student.getViolationScore();
        if(cur == null) cur = score;
        else cur =(short) (cur+score);
        student.setViolationScore(cur);
        studentMapper.update(student);
    }
}
