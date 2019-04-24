package com.techprimers.db.model;


import javax.persistence.*;

@Entity
public class StudentToCourse {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer Id;

    //@ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    //@JoinColumn(name = "userId", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private Customer customer;

//    @ManyToOne(targetEntity = TCourse.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "CourseId", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false)
    private TCourse tcourse;

    public StudentToCourse(){

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TCourse getTcourse() {
        return tcourse;
    }

    public void setTcourse(TCourse tcourse) {
        this.tcourse = tcourse;
    }
}
