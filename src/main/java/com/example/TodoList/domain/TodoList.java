package com.example.TodoList.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter@Setter
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="contents")
    private String contents;

    @Column(name="finish")
    @ColumnDefault("0")
    private int finish;

    public TodoList(String content) {
        this.contents = content;
    }
}
