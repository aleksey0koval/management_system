package com.kovalchuk.management_system.controller.exception_handling;

public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException(String message) {
        super(message);
    }
}
