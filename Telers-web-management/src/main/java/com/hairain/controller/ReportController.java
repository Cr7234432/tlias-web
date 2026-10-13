package com.hairain.controller;

import com.hairain.pojo.ClazzCountOption;
import com.hairain.pojo.JobOption;
import com.hairain.pojo.Result;
import com.hairain.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * ClassName:reportController
 * Package: com.hairain.controller
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/8 16:39
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计员工职位人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别人数");
        List<Map<String,Object>> list =  reportService.getEmpGenderData();
        return Result.success(list);
    }

    @GetMapping("/studentDegreeData")
    public Result getStuDegree(){
        List<Map<String,Object>> list = reportService.getStuDegree();
        return Result.success(list);
    }

    @GetMapping("/studentCountData")
    public Result getClazzData(){
        ClazzCountOption clazzCountOption = reportService.getClazzData();
        return Result.success(clazzCountOption);
    }
}
