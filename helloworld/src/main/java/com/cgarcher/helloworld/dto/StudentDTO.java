package com.cgarcher.helloworld.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Builder
public class StudentDTO {

    private static int count_id = 1;
    @Schema(description = "Identificador del estudiante", example = "1")
    private Integer id;
    @Schema(description = "Nombre del estudiante", example = "Yasmine rmali")
    private String name;
    @Schema(description = "Email del estudiante", example = "yasmine@alu.murciaeduca.es")
    private String mail;
    @Schema(description = "Fecha de nacimiento yy-MM-dd", example = "12-12-1988")
    private LocalDate date_born;

    public StudentDTO(String name, String mail, LocalDate date_born) {
        this.id = count_id;
        count_id++;
        this.name = name;
        this.mail = mail;
        this.date_born = date_born;
    }
}
