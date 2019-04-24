package com.techprimers.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TCourse {
    @Id
    @GeneratedValue
    @Column(name = "courseId")
    private Integer courseId;
    @Column(name = "courseName")
    private String courseName;
    @Column(name = "courseLocation")
    private String courseLocation;
    @Column(name = "courseSubject")
    private String courseSubject;
    @Column(name = "teacherId")
    private String teacherId;


    public String getCourseSubject() {
        return courseSubject;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public void setCourseSubject(String courseSubject) {
        this.courseSubject = courseSubject;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}
