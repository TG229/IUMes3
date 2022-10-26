package com.example.myapplication;

import java.io.Serializable;

public class Person implements Serializable {
    private String name, surname,birthDate;

    public Person (){
        this.setName("");
        this.setSurname("");
        this.setBirthDate("");
    }
    public Person(String name, String surname, String birthDate) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
