package com.hairain.controller;

import com.hairain.anno.Log;
import com.hairain.pojo.PageResult;
import com.hairain.pojo.Result;
import com.hairain.pojo.StuQueryParam;
import com.hairain.pojo.Student;
import com.hairain.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:StudentController
 * Package: com.hairain.controller
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/9 15:00
 * @Version 1.0
 */
@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    //分页查询
    @GetMapping
    public Result list(StuQueryParam stuQueryParam){
        PageResult<Student> pageResult = studentService.list(stuQueryParam);
        return Result.success(pageResult);
    }

    //删除学员
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        studentService.delete(id);
        return Result.success();
    }

    //添加学员
    @Log
    @PostMapping
    public Result insert(@RequestBody Student student){
        studentService.insert(student);
        return Result.success();
    }

    //修改学员
    //1.查询回显
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Student student = studentService.findById(id);
        return Result.success(student);
    }
    //2.更新数据
    @Log
    @PutMapping
    public Result update(@RequestBody Student student){
        studentService.update(student);
        return Result.success();
    }

    //违纪处理
    @Log
    @PutMapping("/violation/{id}/{score}")
    public Result punish(@PathVariable Integer id , @PathVariable Short score){
        studentService.punish(id,score);
        return Result.success();
    }

}
