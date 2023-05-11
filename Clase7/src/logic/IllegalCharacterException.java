package logic;

public class IllegalCharacterException extends RuntimeException {
    private char c;

    public IllegalCharacterException(char c) {
        this.c = c;
    }

    public IllegalCharacterException(String message, char c) {
        super(message);
        this.c = c;
    }

    public IllegalCharacterException(String message, Throwable cause, char c) {
        super(message, cause);
        this.c = c;
    }

    public IllegalCharacterException(Throwable cause, char c) {
        super(cause);
        this.c = c;
    }

    public IllegalCharacterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, char c) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.c = c;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + this.c;
    }
}
