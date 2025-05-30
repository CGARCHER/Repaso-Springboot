package student.exception;

public class NotFoundStudentException extends RuntimeException{
    public NotFoundStudentException(String message) {
        super(message);
    }
}
