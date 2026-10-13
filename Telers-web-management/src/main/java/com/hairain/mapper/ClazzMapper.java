package com.hairain.mapper;

import com.hairain.pojo.Clazz;
import com.hairain.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * ClassName:ClazzMapper
 * Package: com.hairain.mapper
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/9 12:18
 * @Version 1.0
 */
@Mapper
public interface ClazzMapper {

    List<Clazz> findAll(ClazzQueryParam clazzQueryParam);

    @Delete("delete from clazz where id = #{id}")
    void delete(Integer id);


    void save(Clazz clazz);

    @Select("select * from clazz where id = #{id}")
    Clazz findById(Integer id);

    void update(Clazz clazz);

    @Select("select * from clazz")
    List<Clazz> findAlll();
}
