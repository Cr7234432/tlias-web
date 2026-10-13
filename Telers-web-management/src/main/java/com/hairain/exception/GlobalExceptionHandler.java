package com.hairain.exception;

import com.hairain.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName:GlobalExceptionHandler
 * Package: com.hairain.exception
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/8 15:58
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("出错",e);
        return Result.error("出现错误");
    }

    @ExceptionHandler
    public Result handleIllegalStateException(IllegalStateException i){
        return Result.error("该部门有员工，无法删除");
    }

    @ExceptionHandler
    public Result handleClazzException(ClazzException c){
        return Result.error("该班级下有学生，无法删除");
    }


    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException d){
        log.error("主键重复出错",d);
        String message = d.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg  = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2]+"已被占用");
    }
}
