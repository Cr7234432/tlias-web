package com.hairain.mapper;

import com.hairain.pojo.StuQueryParam;
import com.hairain.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * ClassName:StudentMapper
 * Package: com.hairain.mapper
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/9 15:02
 * @Version 1.0
 */
@Mapper
public interface StudentMapper {

    List<Student> list(StuQueryParam stuQueryParam);

    @Delete("delete from student where id = #{id}")
    void delete(Integer id);

    void insert(Student student);

    @Select("select * from student where id = #{id}")
    Student findById(Integer id);

    void update(Student student);

    List<Map<String, Object>> getStuDegree();

    List<Map<String, Object>> getClazzData();

    @Select("select * from student where clazz_id = #{id}")
    List<Student> findByClazz(Integer id);
}
