package com.cgarcher.helloworld.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Builder
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
}
