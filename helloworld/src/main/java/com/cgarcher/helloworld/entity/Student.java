package com.cgarcher.helloworld.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String mail;
    private LocalDate date_born;

    public Student() {}

    public Student(Integer id, String name, String mail, LocalDate date_born) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.date_born = date_born;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate_born() {
        return date_born;
    }

    public void setDate_born(LocalDate date_born) {
        this.date_born = date_born;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
