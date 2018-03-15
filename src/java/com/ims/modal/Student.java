/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.modal;

/**
 *
 * @author stim
 */
public class Student {
    private int id;
    private String name;
    private String country;
    private String gender;
    private String hobbies;

    public Student() {
    }

    public Student(String name, String country, String gender, String hobbies) {
        this.name = name;
        this.country = country;
        this.gender = gender;
        this.hobbies = hobbies;
    }

    public Student(int id, String name, String country, String gender, String hobbies) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.gender = gender;
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
    
    
    
}
