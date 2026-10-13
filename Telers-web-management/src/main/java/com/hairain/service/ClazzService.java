package com.hairain.service;

import com.hairain.pojo.Clazz;
import com.hairain.pojo.ClazzQueryParam;
import com.hairain.pojo.PageResult;

import java.util.List;

/**
 * ClassName:ClazzService
 * Package: com.hairain.service
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/9 12:16
 * @Version 1.0
 */
public interface ClazzService {
    PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam);

    void delete(Integer id);

    void save(Clazz clazz);

    Clazz findById(Integer id);

    void update(Clazz clazz);

    List<Clazz> findAlll();
}
