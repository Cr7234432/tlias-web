package com.hairain.controller;

import com.hairain.anno.Log;
import com.hairain.pojo.Dept;
import com.hairain.pojo.Result;
import com.hairain.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:DeptController
 * Package: com.hairain.controller
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/5 16:11
 * @Version 1.0
 */
@RequestMapping("/depts")
@RestController
@Slf4j
public class DeptController {

//    private static final Logger log  = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    //查询全部部门
//    @RequestMapping(value = "/depts" , method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList =  deptService.findAll();
        return Result.success(deptList);
    }

    //删除部门
    //方式一：
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request){
//        String sid = request.getParameter("id");
//        int id = Integer.parseInt(sid);
//        System.out.println("删除id为" + id + "的部门");
//        deptService.deleteById();
//        return Result.success();
//    }

    //方式二：
    @Log
    @DeleteMapping
    public Result delete(Integer id) throws Exception {
        log.info("删除id为{}的部门",id);
        deptService.deleteById(id);
        return Result.success();
    }


    //添加部门
    @Log
    @PostMapping
    public Result add( @RequestBody Dept dept){
        log.info("插入的部门名称为{}",dept.getName());
        deptService.insertName(dept);
        return Result.success();
    }


    //编辑部门
    //1.查询回显
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("所获取的id为{}" ,id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    //2.修改部门数据
    @Log
    @PutMapping
    public Result putInfo(@RequestBody Dept dept){
        log.info(dept.toString());
        deptService.update(dept);
        return Result.success();
    }

}
