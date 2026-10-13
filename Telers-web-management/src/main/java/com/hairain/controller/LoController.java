package com.hairain.controller;

import com.github.pagehelper.Page;
import com.hairain.pojo.OperateLog;
import com.hairain.pojo.PageResult;
import com.hairain.pojo.PageVar;
import com.hairain.pojo.Result;
import com.hairain.service.OpreaterLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:LoController
 * Package: com.hairain.controller
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/11 16:14
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LoController {

    @Autowired
    private OpreaterLogService opreaterLogService;

    @GetMapping("/page")
    public Result logSelect(PageVar pageVar){
        PageResult<OperateLog> pageResult = opreaterLogService.logSelect(pageVar);
        return Result.success(pageResult);
    }
}
