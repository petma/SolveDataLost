package com.cqgg.core.exception;

public class PullDataException extends Exception {
    private String message;
    private boolean isbreak;

    public PullDataException(String message, boolean isbreak) {
        super(message);
        this.isbreak = isbreak;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public boolean isBreak() {
        return isbreak;
    }
}
