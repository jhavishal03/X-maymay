package com.Dark.Xmaymay.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class duplicateMemeException extends RuntimeException{

    public duplicateMemeException(String message) {
    super(message);
    }
}
