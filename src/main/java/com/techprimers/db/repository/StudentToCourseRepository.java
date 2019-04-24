package com.techprimers.db.repository;

import com.techprimers.db.model.Customer;
import com.techprimers.db.model.StudentToCourse;
import com.techprimers.db.model.TCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface StudentToCourseRepository extends JpaRepository<StudentToCourse, Integer> {
//    @Query("select * from student_to_course st where st.course_id = :userId")
     List<StudentToCourse> findByCustomer(Customer customer);

     List<StudentToCourse> findByTcourse(TCourse tcourse);

     List<StudentToCourse> findByTcourseAndCustomer(TCourse tcourse, Customer customer);
}
