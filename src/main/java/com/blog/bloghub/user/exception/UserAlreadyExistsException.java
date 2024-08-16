package com.blog.bloghub.user.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
