package com.hairain.controller;

import com.hairain.anno.Log;
import com.hairain.pojo.Emp;
import com.hairain.pojo.EmpQueryParam;
import com.hairain.pojo.PageResult;
import com.hairain.pojo.Result;
import com.hairain.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:EmpController
 * Package: com.hairain.controller
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/6 17:12
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;


    @GetMapping("/list")
    public Result listAll(){
        log.info("查询所有");
        List<Emp> list = empService.findAll();
        return Result.success(list);
    }


    //用户功能1：查询
    @GetMapping
    public Result list(EmpQueryParam empQueryParam){
        log.info("分页查询：{}",empQueryParam);
        PageResult<Emp> pageResult = empService.find(empQueryParam);
        return Result.success(pageResult);
    }

    //用户功能2：新增
    @Log
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增用户:{}",emp);
        empService.save(emp);
        return Result.success();
    }


    //用户功能3：删除
//    @DeleteMapping
//    public Result delete(Integer[] ids){
//        log.info("需要删除的id {}", Arrays.toString(ids));
//        return Result.success();
//    }

    @DeleteMapping
    @Log
    public Result delete(@RequestParam List<Integer> ids){
        log.info("需要删除的id {}", ids);
        empService.delete(ids);
        return Result.success();
    }

    //用户功能4： 修改
    //查询回显
    @GetMapping("{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询id：{}",id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
    //修改信息
    @Log
    @PutMapping
    public Result putInfo(@RequestBody Emp emp){
        log.info("需要修改的信息{}",emp);
        empService.update(emp);
        return Result.success();
    }



}
