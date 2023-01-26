package com.example.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT ,reason = "użytownik z tym peselem już istnieje")
public class UserPeselDuplicateException extends RuntimeException {
}
