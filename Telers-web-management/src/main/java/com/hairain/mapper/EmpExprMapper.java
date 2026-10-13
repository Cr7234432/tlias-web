package com.hairain.mapper;

import com.hairain.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:EmpExprMapper
 * Package: com.hairain.mapper
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/6 17:11
 * @Version 1.0
 */
@Mapper
public interface EmpExprMapper {


    void inserts(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> empIds);
}
