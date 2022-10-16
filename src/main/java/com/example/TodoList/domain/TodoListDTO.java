package com.example.TodoList.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TodoListDTO {
    @NotBlank
    private String contents;

    private int finish;
}
