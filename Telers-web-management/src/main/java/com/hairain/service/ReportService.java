package com.hairain.service;

import com.hairain.pojo.ClazzCountOption;
import com.hairain.pojo.JobOption;

import java.util.List;
import java.util.Map;

/**
 * ClassName:ReportService
 * Package: com.hairain.service.impl
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/8 16:40
 * @Version 1.0
 */
public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    List<Map<String, Object>> getStuDegree();

    ClazzCountOption getClazzData();
}
