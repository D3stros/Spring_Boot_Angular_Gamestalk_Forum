package com.Gamestalk.springnggamestalk.exception;

public class SpringGamestalkException extends RuntimeException {
    public SpringGamestalkException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringGamestalkException(String exMessage) {
        super(exMessage);
    }
}
