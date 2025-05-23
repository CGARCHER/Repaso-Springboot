package com.cgarcher.helloworld.dto;

import java.time.LocalDate;

public class StudentDTO {

    private static int count_id = 1;
    private Integer id;
    private String name;
    private String mail;
    private LocalDate date_born;

    public StudentDTO(String name, String mail, LocalDate date_born) {
        this.id = count_id;
        count_id++;
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
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", date_born=" + date_born +
                '}';
    }
}
