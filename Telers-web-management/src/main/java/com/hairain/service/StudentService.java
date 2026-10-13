package com.hairain.service;

import com.hairain.pojo.PageResult;
import com.hairain.pojo.StuQueryParam;
import com.hairain.pojo.Student;

/**
 * ClassName:StudentService
 * Package: com.hairain.service
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/9 15:01
 * @Version 1.0
 */
public interface StudentService {
    PageResult<Student> list(StuQueryParam stuQueryParam);

    void delete(Integer id);

    void insert(Student student);

    Student findById(Integer id);

    void update(Student student);

    void punish(Integer id, Short score);
}
