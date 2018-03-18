package pl.narodzinyprogramsity.exceptions;

public class NotCorrectLineException extends Exception {
    public NotCorrectLineException() {
        super("This line is broken");
    }
}
