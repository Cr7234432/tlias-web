package com.hairain.mapper;

import com.hairain.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName:DeptMapper
 * Package: com.hairain.mapper
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/5 16:09
 * @Version 1.0
 */
@Mapper
public interface DeptMapper {

    //查询所有的部门数据
//    @Results({
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime")
//    })
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime})")
    void insertName(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{id} ")
    Dept getById(Integer id);

    @Update("update dept set name = #{name} ,update_time = #{updateTime} where id = #{id};")
    void update(Dept dept);
}
