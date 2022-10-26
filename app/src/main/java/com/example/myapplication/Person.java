package com.example.myapplication;

import java.io.Serializable;
import java.util.Calendar;

public class Person implements Serializable {
    private String name, surname;



    private Calendar birthDate;

    public Person (){
        this.setName("");
        this.setSurname("");
        //this.setBirthDate("");
    }
    public Person(String name, String surname, Calendar birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
}
