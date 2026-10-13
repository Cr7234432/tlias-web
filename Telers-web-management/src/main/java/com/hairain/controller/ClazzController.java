package com.hairain.controller;

import com.aliyun.core.annotation.Path;
import com.hairain.anno.Log;
import com.hairain.pojo.Clazz;
import com.hairain.pojo.ClazzQueryParam;
import com.hairain.pojo.PageResult;
import com.hairain.pojo.Result;
import com.hairain.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:ClazzController
 * Package: com.hairain.controller
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/9 12:15
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;


    //查询所有班级
    @GetMapping("/list")
    public Result findAlll(){
        List<Clazz> list = clazzService.findAlll();
        return Result.success(list);
    }


    //分页列表查询
    @GetMapping
    public Result findAll(ClazzQueryParam clazzQueryParam){
        log.info("所要查询的数据,{}",clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.findAll(clazzQueryParam);
        return Result.success(pageResult);
    }

    //删除班级
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("所要删除的班级id为：{}",id);
        clazzService.delete(id);
        return Result.success();
    }

    //添加班级
    @Log
    @PostMapping
    public Result sava(@RequestBody Clazz clazz){
        log.info("所要添加的班级信息：{}",clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    //查询回显
    //1.根据id查询对应班级
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("所要查询的班级id为：{}",id);
        Clazz clazz = clazzService.findById(id);
        return Result.success(clazz);
    }

    //2.修改对应班级的数据
    @Log
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改后的数据为：{}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }

}
