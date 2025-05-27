package com.cgarcher.helloworld.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CreateStudentRequest {

    @NotEmpty
    private String name;
    @NotEmpty @Email
    private String mail;
    @Past
    private LocalDate date_born;

    public CreateStudentRequest(String name, String mail, LocalDate date_born) {
        this.name = name;
        this.mail = mail;
        this.date_born = date_born;
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
}
