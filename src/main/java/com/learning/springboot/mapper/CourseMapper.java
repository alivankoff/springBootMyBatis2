package com.learning.springboot.mapper;


import com.learning.springboot.model.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Insert("INSERT INTO course (name, description, credits, professor) VALUES (#{name}," +
            "#{description}, #{credits}, #{professor})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false,
            resultType = Integer.class)
    void insert(Course course);

    @Select("SELECT * FROM COURSE ")
    List<Course> findAll();

    @Select("SELECT * FROM COURSE WHERE id = #{id}")
    Course getCourseById(Integer id);

    @Update("UPDATE COURSE SET name=#{name}, description=#{description}, credits=#{credits}, " +
            "professor=#{professor} where id=#{id}")
    void update(Course course);

    @Delete("DELETE FROM COURSE WHERE id = #{id}")
    void delete(@Param("id") Integer id);
}
