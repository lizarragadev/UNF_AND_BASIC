package com.miramicodigo.basicexam;

import java.io.Serializable;

/**
 *
 * @author Gustavo Lizarraga
 * @date 12-06-2017
 *
 * */

public class Student implements Serializable {
    private String fullName;
    private String gender;
    private int age;
    private String user;
    private String pass;

    public Student() {

    }

    public Student(String fullName, String gender, int age, String user, String pass) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.user = user;
        this.pass = pass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
