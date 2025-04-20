package customexceptions;

public class TooManyStudentsException extends RuntimeException {
    public TooManyStudentsException(String message) {
        super(message);
    }
}
