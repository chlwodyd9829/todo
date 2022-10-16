package com.example.TodoList.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter@Setter
@AllArgsConstructor
public class ErrorResult {
    private String code;
    private String message;
}
