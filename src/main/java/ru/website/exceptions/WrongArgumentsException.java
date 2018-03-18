package ru.website.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ленар on 18.03.2018.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongArgumentsException extends RuntimeException {

    public WrongArgumentsException(String message) {
        super(message);
    }
}
