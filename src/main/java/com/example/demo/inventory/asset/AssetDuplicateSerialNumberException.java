package com.example.demo.inventory.asset;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT , reason = "Wyposażenie z takim numerem seryjnym już istnieje")
public class AssetDuplicateSerialNumberException extends RuntimeException {
}

