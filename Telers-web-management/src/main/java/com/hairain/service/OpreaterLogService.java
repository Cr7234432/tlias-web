package com.hairain.service;

import com.hairain.pojo.OperateLog;
import com.hairain.pojo.PageResult;
import com.hairain.pojo.PageVar;

/**
 * ClassName:OpreaterLogService
 * Package: com.hairain.service
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/11 16:16
 * @Version 1.0
 */
public interface OpreaterLogService {
    PageResult<OperateLog> logSelect(PageVar pageVar);
}
