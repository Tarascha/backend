package com.techprimers.db.controller;

import com.techprimers.db.model.StudentToCourse;
import com.techprimers.db.model.TCourse;
import com.techprimers.db.model.Customer;
import com.techprimers.db.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.techprimers.db.repository.CourseRepository;
import com.techprimers.db.repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CustomerRepository customerRepository;

    @CrossOrigin
    @GetMapping(path = "/users/{userName}/{passWord}", produces="application/json")
    public HttpEntity GetOneUser(@PathVariable String userName, @PathVariable String passWord){
        //System.out.println(userName);
        //System.out.println(passWord);
        Customer guy = courseService.GetOneCustomer(userName, passWord);
        if(guy == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(guy, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(path = "/user", produces="application/json")
    public HttpEntity RegisterUser(@RequestBody Customer user){
        Customer u = courseService.RegisterCustomer(user);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/user/{userName}", produces="application/json")
    public HttpEntity CheckUserExists(@PathVariable String userName){
        Customer guy = customerRepository.findByUserName(userName);
        if(guy == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(guy, HttpStatus.OK);
    }
//
//
//    // ------------- course controller --------------
//
    @CrossOrigin
    @GetMapping(path = "/course/{teachId}", produces="application/json")
    public HttpEntity GetTeacherCourse(@PathVariable String teachId){
        List<TCourse> currentCourses = courseService.GetTeacherCourse(teachId);

        return new ResponseEntity<>(currentCourses, HttpStatus.OK);
    }
//
    @CrossOrigin
    @GetMapping(path = "/course/one/{courseId}", produces="application/json")
    public HttpEntity getSingleCourse(@PathVariable String courseId){
        TCourse currentCourses = courseService.getCourse(Integer.valueOf(courseId));

        return new ResponseEntity<>(currentCourses, HttpStatus.OK);
    }
//
    @CrossOrigin
    @PutMapping(path = "/course/one/{courseId}", produces="application/json")
    public HttpEntity putCourse(@RequestBody TCourse tcourse, @PathVariable String courseId){
        TCourse currentCourses = courseService.putCourse(tcourse, courseId);

        return new ResponseEntity<>(currentCourses, HttpStatus.OK);
    }
//
    @CrossOrigin
    @PostMapping(path = "/course/add", produces="application/json")
    public HttpEntity postCourse(@RequestBody TCourse tcourse){
        TCourse currentCourses = courseService.postCourse(tcourse);

        return new ResponseEntity<>(currentCourses, HttpStatus.OK);
    }
//
    @CrossOrigin
    @DeleteMapping(path = "/course/one/{courseId}", produces="application/json")
    public HttpEntity deleteCourse(@PathVariable Integer courseId){
        TCourse currentCourses = courseService.deleteCourse(courseId);

        return new ResponseEntity<>(currentCourses, HttpStatus.OK);
    }
//
    @CrossOrigin
    @GetMapping(path = "/course", produces="application/json")
    public HttpEntity getAllCourses(){
        List<TCourse> currentCourses = courseService.getAllCourses();

        return new ResponseEntity<>(currentCourses, HttpStatus.OK);
    }
//
    @CrossOrigin
    @GetMapping(path = "/course/look/{studentId}", produces="application/json")
    public HttpEntity GetStudentCourse(@PathVariable String studentId){
        Integer stid = new Integer(Integer.valueOf(studentId));
        Customer curStudent = courseService.findOneCust(stid);
        List<TCourse> currentCourses = courseService.GetStudentCourse(curStudent);

        return new ResponseEntity<>(currentCourses, HttpStatus.OK);
    }
//
    @CrossOrigin
    @DeleteMapping(path = "/course/drop/{courseId}/{studentId}", produces="application/json")
    public HttpEntity dropCourse(@PathVariable String courseId, @PathVariable String studentId){
        Integer stid = Integer.valueOf(studentId);
        Integer csid = Integer.valueOf(courseId);
        Customer curStudent = courseService.findOneCust(stid);
        TCourse curCourse = courseService.getCourse(csid);
        courseService.dropCourse(curCourse, curStudent);

        return new ResponseEntity<>(HttpStatus.OK);
    }
//
    @CrossOrigin
    @PostMapping(path = "/course/register/{studentId}/{courseId}", produces="application/json")
    public HttpEntity registerCourse(@PathVariable String studentId, @PathVariable String courseId){
        Integer stid = Integer.valueOf(studentId);
        Integer csid = Integer.valueOf(courseId);
        Customer curStudent = courseService.findOneCust(stid);
        TCourse curCourse = courseService.getCourse(csid);
        StudentToCourse stt = new StudentToCourse();
        stt.setCustomer(curStudent);
        stt.setTcourse(curCourse);
        StudentToCourse st = courseService.registerCourse(stt);

        return new ResponseEntity<>(st, HttpStatus.OK);
    }
//
    @CrossOrigin
    @GetMapping(path = "/course/hook/{courseId}", produces="application/json")
    public HttpEntity getStudentsRegiteredForThisCourse(@PathVariable String courseId){
        Integer csid = Integer.valueOf(courseId);
        TCourse curCourse = courseService.getCourse(csid);
        List<Customer> guy = courseService.getStudentsRegiteredForThisCourse(curCourse);

        return new ResponseEntity<>(guy, HttpStatus.OK);
    }


}
