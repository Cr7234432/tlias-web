package com.hairain.controller;

import com.hairain.pojo.Emp;
import com.hairain.pojo.LogInfo;
import com.hairain.pojo.Result;
import com.hairain.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:LogController
 * Package: com.hairain.controller
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/10 18:21
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/login")
public class LogController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        LogInfo logInfo =  empService.login(emp);
        if(logInfo!=null) return Result.success(logInfo);
        else return Result.error("用户名或密码错误");
    }
}
