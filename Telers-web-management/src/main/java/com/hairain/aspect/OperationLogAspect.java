package com.hairain.aspect;

import com.hairain.mapper.OperateLogMapper;
import com.hairain.pojo.OperateLog;
import com.hairain.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * ClassName:OperationLogAspect
 * Package: com.hairain.aspect
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/11 15:12
 * @Version 1.0
 */

@Aspect
@Component
@Slf4j
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.hairain.anno.Log)")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws  Throwable{
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long costTime = endTime-startTime;

        OperateLog olog = new OperateLog();
        olog.setOperateEmpId(getCurrentUserId());
        olog.setOperateTime(LocalDateTime.now());
        olog.setClassName(joinPoint.getTarget().getClass().getName());
        olog.setMethodName(joinPoint.getSignature().getName());
        olog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        olog.setReturnValue(result != null?result.toString():"void");
        olog.setCostTime(costTime);

        operateLogMapper.insert(olog);
        log.info("记录操作日志：{}",olog);

        return result;
    }

    private Integer getCurrentUserId(){
        return CurrentHolder.getCurrentId();
    }
}
