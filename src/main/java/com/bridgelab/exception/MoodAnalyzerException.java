package com.bridgelab.exception;

public class MoodAnalyzerException extends Exception {
    public ExceptionType type;

    public enum ExceptionType{
        ENTERED_NULL,NO_SUCH_CLASS,NO_SUCH_METHOD, ENTERED_EMPTY
    }

    public MoodAnalyzerException(ExceptionType type,String message) {
        super(message);
        this.type=type;
    }

}
