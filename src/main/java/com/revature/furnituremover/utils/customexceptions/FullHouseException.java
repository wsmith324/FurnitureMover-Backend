package com.revature.furnituremover.utils.customexceptions;

public class FullHouseException extends RuntimeException {
    public FullHouseException() {}

    public FullHouseException(String message) {
        super(message);
    }

    public FullHouseException(String message, Throwable cause) {
        super(message, cause);
    }

    public FullHouseException(Throwable cause) {
        super(cause);
    }

    public FullHouseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
