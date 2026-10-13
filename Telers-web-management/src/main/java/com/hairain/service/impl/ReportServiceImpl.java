package com.hairain.service.impl;

import com.hairain.controller.EmpController;
import com.hairain.mapper.ClazzMapper;
import com.hairain.mapper.EmpMapper;
import com.hairain.mapper.StudentMapper;
import com.hairain.pojo.ClazzCountOption;
import com.hairain.pojo.JobOption;
import com.hairain.pojo.Student;
import com.hairain.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:ReportServiceImpl
 * Package: com.hairain.service.impl
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/8 16:40
 * @Version 1.0
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list =  empMapper.countEmpJobData();

        List<Object> joblist = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> datalist = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(joblist,datalist);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map<String, Object>> getStuDegree() {
        return studentMapper.getStuDegree();
    }

    @Override
    public ClazzCountOption getClazzData() {
        List<Map<String,Object>> list = studentMapper.getClazzData();
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("name")).toList();
        List<Object> datalist = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new ClazzCountOption(clazzList,datalist);
    }
}
