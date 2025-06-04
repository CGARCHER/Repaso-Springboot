package student.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Builder
public class StudentDTO {

    @Schema(description = "Identificador del estudiante", example = "1")
    private Integer id;
    @Schema(description = "Nombre del estudiante", example = "Yasmine rmali")
    private String name;
    @Schema(description = "Email del estudiante", example = "yasmine@alu.murciaeduca.es")
    private String mail;
    @Schema(description = "Fecha de nacimiento yy-MM-dd", example = "12-12-1988")
    private LocalDate date_born;
    @Schema(description = "Indica si el estudiante a finalizado los estudios")
    private boolean finished;
}
