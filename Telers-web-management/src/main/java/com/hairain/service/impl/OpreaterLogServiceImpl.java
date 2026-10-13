package com.hairain.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hairain.mapper.OperateLogMapper;
import com.hairain.pojo.OperateLog;
import com.hairain.pojo.PageResult;
import com.hairain.pojo.PageVar;
import com.hairain.service.OpreaterLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:OpreaterLogServiceImpl
 * Package: com.hairain.service.impl
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/11 16:16
 * @Version 1.0
 */
@Service
public class OpreaterLogServiceImpl implements OpreaterLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<OperateLog> logSelect(PageVar pageVar) {
        PageHelper.startPage(pageVar.getPage(),pageVar.getPageSize());
        List<OperateLog> list = operateLogMapper.logSelect(pageVar);
        Page<OperateLog> p = (Page<OperateLog>) list;
        return new PageResult<>(p.getTotal(),list);
    }
}
