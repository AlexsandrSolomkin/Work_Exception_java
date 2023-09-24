package dz_2.dz_2_4;

public class StringNullException extends Exception {
    public StringNullException() {

    }

    public StringNullException(String message) {
        super(message);
    }

    public StringNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringNullException(Throwable cause) {
        super(cause);
    }

    public StringNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
