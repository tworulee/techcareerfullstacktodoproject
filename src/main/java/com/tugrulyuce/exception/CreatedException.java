package com.tugrulyuce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
// 1xx = Information
// 2xx = Success
// 3xx = redirect
// 4xx = Client hatası
// 5xx = Server hatası

// 201: created
@ResponseStatus(value = HttpStatus.CREATED)
public class CreatedException extends RuntimeException{

    public CreatedException(String message) {
        super(message);
    }
}
