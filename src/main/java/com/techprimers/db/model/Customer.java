package com.techprimers.db.model;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name="UserId")
    private Integer UserId;

    @Column(name="userName")
    private String userName;
    @Column(name="passWord")
    private String passWord;
    @Column(name="identity")
    private String identity;//Teacher or Student

    public Customer(){

    }

    public Integer getUserId() {
        return UserId;
    }
    public  String getUserName(){
        return userName;
    }

    public void setUserId(Integer userId) {
        this.UserId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPassWord(){
        return passWord;
    }
    public String getIdentity(){
        return identity;
    }

}
