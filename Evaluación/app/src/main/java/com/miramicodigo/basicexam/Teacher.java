package com.miramicodigo.basicexam;

/**
 *
 * @author Gustavo Lizarraga
 * @date 12-06-2017
 *
 * */

public class Teacher {
    private String fullName;
    private String career;
    private String gender;

    public Teacher() {

    }

    public Teacher(String fullName, String career, String gender) {
        this.fullName = fullName;
        this.career = career;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
