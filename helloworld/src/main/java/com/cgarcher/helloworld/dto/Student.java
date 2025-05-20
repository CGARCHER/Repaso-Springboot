package com.cgarcher.helloworld.dto;

import java.time.LocalDate;
import java.util.Objects;

public class Student {

    private static int id = 0;
    private String name;
    private String mail;
    private LocalDate date_born;

    public Student(String name, String mail, LocalDate date_born) {
        id++;
        this.name = name;
        this.mail = mail;
        this.date_born = date_born;
    }

    public static int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getDate_born() {
        return date_born;
    }

    public void setDate_born(LocalDate date_born) {
        this.date_born = date_born;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", date_born=" + date_born +
                '}';
    }
}
