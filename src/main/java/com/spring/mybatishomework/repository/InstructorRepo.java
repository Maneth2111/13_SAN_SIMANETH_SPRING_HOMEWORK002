package com.spring.mybatishomework.repository;

import com.spring.mybatishomework.model.Instructor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepo {
    @Select("""
    select  * from instructors
    offset  #{size} * (#{page}-1)
    limit   #{size}
    """)
    @Results(id = "instructorMapping",value = {
            @Result(property = "instructorId",column = "instructor_id"),
            @Result(property = "instructorName",column = "instructor_name"),
            @Result(property = "instructorEmail",column = "email")
    })
    List<Instructor> getInstructor(Integer page, Integer size);



    @Select("""
        select * from instructors
        where instructor_id = #{id};
    """)
    @ResultMap("instructorMapping")
    Instructor findInstructorById(Integer id);

    @Insert("""
        INSERT INTO instructors(instructor_name, email) 
        VALUES (#{instructorName}, #{instructorEmail}) RETURNING instructor_id

    """)
    Integer createInstructor(Instructor instructor);


    @Update("UPDATE instructors SET instructor_name = #{instructorName}, email = #{instructorEmail} WHERE instructor_id = #{instructorId}")
    void updateInstructor(Instructor instructor);

    @Delete("DELETE FROM instructors WHERE instructor_id = #{id}")
    void deleteInstructor(Integer id);

}
