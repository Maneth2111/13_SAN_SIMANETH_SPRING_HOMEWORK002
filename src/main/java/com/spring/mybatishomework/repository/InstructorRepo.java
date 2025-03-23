package com.spring.mybatishomework.repository;

import com.spring.mybatishomework.model.Instructor;
import com.spring.mybatishomework.model.request.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepo {
    @Select("select * from instructors")
    @Results(id = "instructorMapping",value = {
            @Result(property = "instructorId",column = "instructor_id"),
            @Result(property = "instructorName",column = "instructor_name"),
            @Result(property = "instructorEmail",column = "email")
    })
    List<Instructor> getInstructor();



    @Select("""
        select * from instructors
        where instructor_id = #{id};
    """)
    @ResultMap("instructorMapping")
    Instructor findInstructorById(Integer id);


    @Select("""
        insert into instructors(instructor_name, email)
        values (#{Instructor.instructorName},#{Instructor.instructorEmail})
        returning instructor_id;
    """)
    @ResultMap("instructorMapping")
    Instructor createInstructor(@Param("Instructor") InstructorRequest request);

//    void updateInstructor(Integer id, InstructorRequest request);

    @Insert("update instructors set instructor_name = #{instructor.instructorName}, email = #{instructor.instructorEmail} where instructor_id = #{id}")
    void updateInstructor(@Param("id") Integer id, @Param("instructor") InstructorRequest instructor);

//        @Update("""
//        update instructors
//        set instructor_name = #{instructorName}, email = #{instructorEmail}
//        where instructor_id = #{instructorId}
//        returning *
//    """)
//    @ResultMap("instructorMapping")
//    Instructor updateInstructor(Integer id, InstructorRequest request);
//


//    @Select("""
//        update instructors
//        set instructor_name = #{Instructor.instructorName}, email = #{Instructor.instructorEmail}
//        where instructor_id = #{Instructor.instructorId}
//        returning *
//    """)
//    @ResultMap("instructorMapping")
//    Instructor updateInstructorById(Integer id,Instructor request);
}
