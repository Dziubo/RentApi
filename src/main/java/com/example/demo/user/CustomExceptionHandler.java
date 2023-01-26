package com.example.demo.user;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.*;
import java.util.stream.Collectors;
@RestControllerAdvice
public class CustomExceptionHandler   {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex
            ) {

        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("timestamp", new Date());

        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        responseBody.put("errors", errors);
        return new ResponseEntity<>(responseBody , HttpStatus.BAD_REQUEST);
    }
}
