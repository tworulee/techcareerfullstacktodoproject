package com.tugrulyuce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 1xx = Information
// 2xx = Success
// 3xx = redirect
// 4xx = Client hatası
// 5xx = Server hatası

// 404: olursa bu istisnayı yakalayan class
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
