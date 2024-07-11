package exceptions;


public class RestrauntNotPresentException extends RuntimeException {
    public RestrauntNotPresentException(String message)
    {
        super(message);
    }
}
