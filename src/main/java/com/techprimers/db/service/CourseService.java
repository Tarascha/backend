package com.techprimers.db.service;


import com.techprimers.db.model.StudentToCourse;
import com.techprimers.db.model.TCourse;
import com.techprimers.db.model.Customer;
import com.techprimers.db.repository.CourseRepository;
import com.techprimers.db.repository.CustomerRepository;
import com.techprimers.db.repository.StudentToCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    StudentToCourseRepository studenttocourserepository;

    public StudentToCourse registerCourse(StudentToCourse stt){

        return studenttocourserepository.save(stt);

    }

    public Customer findOneCust(Integer StudentId){
        return customerRepository.findOne(StudentId);
    }

    public TCourse getCourse(Integer courseId){
        return courseRepository.findOne(courseId);
    }
//
    public List<TCourse>GetTeacherCourse(String teacherId){
        List<TCourse> res = courseRepository.findByTeacherId(teacherId);
        return  res;
    }
//
//    public TCourse getSingleCourse(String courseId){
//
//    }
//
    public TCourse putCourse(TCourse tcourse, String courseId){
        return courseRepository.saveAndFlush(tcourse);
    }
//
    public TCourse postCourse(TCourse tcourse){
        TCourse tc = courseRepository.save(tcourse);
        return tc;
    }
//
    public TCourse deleteCourse(Integer courseId){
        TCourse tc = courseRepository.findOne(courseId);
        courseRepository.delete(tc);
        return tc;
    }
//
    public List<TCourse> getAllCourses(){
        List<TCourse> tc = courseRepository.findAll();
        return tc;
    }


// -------------------------------------------------------


//
    public List<TCourse> GetStudentCourse(Customer curCust){
        List<StudentToCourse> curSt = studenttocourserepository.findByCustomer(curCust);

        List<TCourse> res = new ArrayList<>();

        for(StudentToCourse st : curSt){
            TCourse curCourse = courseRepository.findOne(st.getTcourse().getCourseId());
            res.add(curCourse);
        }

        return  res;
    }
//
    public void dropCourse(TCourse courseId, Customer studentId){
        List<StudentToCourse> curSt = studenttocourserepository.findByTcourseAndCustomer(courseId, studentId);

        for(StudentToCourse st : curSt){
            studenttocourserepository.delete(st);
        }
    }
//
//
//
    public List<Customer> getStudentsRegiteredForThisCourse(TCourse curCourse){
        List<StudentToCourse> curSt = studenttocourserepository.findByTcourse(curCourse);

        List<Customer> res = new ArrayList<>();

        for(StudentToCourse st : curSt){
            Customer curStudent = customerRepository.findOne(st.getCustomer().getUserId());
            res.add(curStudent);
        }

        return res;
    }
//
    public Customer RegisterCustomer(Customer customer){
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer;
    }

    public Customer GetOneCustomer(String userName, String passWord){
        //System.out.println(userName);
        Customer oneCustomer = customerRepository.findByUserName(userName);
        //Customer oneCustomer = customerRepository.findOne(1);
        if (oneCustomer!=null && oneCustomer.getPassWord().equals(passWord)){
            return oneCustomer;}
        else {
            System.out.println("cannot find proper customer");
            return null;}
    }

}
