package ru.fratask.model;

public enum AppResponseCode {
    UNKNOWN(0, "Unknown exeption"),
    USER_DOES_NOT_EXISTS(1, "User does not exists"),
    USER_ALREADY_EXISTS(2, "User already exists"),
    WRONG_PASSWORD(3, "Wrong password"),
    ;

    private final int code;

    private final String message;

    AppResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
