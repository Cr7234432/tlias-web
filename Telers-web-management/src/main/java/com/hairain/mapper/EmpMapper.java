package com.hairain.mapper;

import com.hairain.pojo.Emp;
import com.hairain.pojo.EmpQueryParam;
import com.hairain.pojo.JobOption;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * ClassName:EmpMapper
 * Package: com.hairain.mapper
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/6 17:10
 * @Version 1.0
 */
@Mapper
public interface EmpMapper {

//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ;")
//    public Long count();
//
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start},#{pageSize};")
//    public List<Emp> list(Integer start,Integer pageSize);

//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id\n" +
//            "                           where e.name like '%#{name}%' and gender = #{gender} and entry_date between '2010-01-01' and '2020-01-01'\n" +
//            "                                 order by e.update_time desc")
    public List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime});")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getInfo(Integer id);

    void updateById(Emp emp);

    List<Map<String,Object>> countEmpJobData();

    List<Map<String,Object>> countEmpGenderData();

    @Select("select * from emp")
    List<Emp> findAll();

    @Select("select * from emp where dept_id = #{id}")
    List<Emp> findByDeptId(Integer id);

    @Select("select name,username,id from emp where username = #{username} and password = #{password} ")
    Emp findByPassandUser(Emp emp);
}
