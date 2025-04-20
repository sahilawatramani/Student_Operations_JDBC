package customexceptions;

public class DeletionNotAllowedException extends Exception {
    public DeletionNotAllowedException(String msg) { super(msg); }
}
