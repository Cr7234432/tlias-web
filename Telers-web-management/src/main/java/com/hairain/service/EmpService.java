package com.hairain.service;

import com.hairain.pojo.Emp;
import com.hairain.pojo.EmpQueryParam;
import com.hairain.pojo.LogInfo;
import com.hairain.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * ClassName:EmpService
 * Package: com.hairain.service
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/6 17:11
 * @Version 1.0
 */
public interface EmpService {

    PageResult<Emp> find(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<Emp> findAll();

    LogInfo login(Emp emp);
}
