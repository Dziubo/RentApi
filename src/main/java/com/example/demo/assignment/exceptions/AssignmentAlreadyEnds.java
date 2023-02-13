package com.example.demo.assignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.BAD_REQUEST ,reason ="wypożyczenie o podanym id zostało zakończone")

public class AssignmentAlreadyEnds extends RuntimeException{
}
