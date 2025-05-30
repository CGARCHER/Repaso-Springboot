package student.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class UpdateStudentRequest {

    private String name;
    private String mail;

    private LocalDate date_born;

    public UpdateStudentRequest(String name, String mail, LocalDate date_born) {
        this.name = name;
        this.mail = mail;
        this.date_born = date_born;
    }

}
