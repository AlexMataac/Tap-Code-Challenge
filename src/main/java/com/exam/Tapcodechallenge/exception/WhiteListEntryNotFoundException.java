package com.exam.Tapcodechallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WhiteListEntryNotFoundException extends RuntimeException {
    public WhiteListEntryNotFoundException(String message) {
        super(message);
    }
}
