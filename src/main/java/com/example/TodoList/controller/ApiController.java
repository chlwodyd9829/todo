package com.example.TodoList.controller;

import com.example.TodoList.domain.TodoList;
import com.example.TodoList.domain.TodoListDTO;
import com.example.TodoList.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/todo/api", produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
@Slf4j
public class ApiController {

    private final TodoService todoService;

    @PostConstruct
    void init(){
        for(int i = 0; i < 5; i++){
            TodoListDTO todoListDTO = new TodoListDTO(Integer.toString(i),0);
            todoService.insert(todoListDTO);
        }
    }
    /**
     * 삽입
     */
    @PostMapping("/insert")
    public TodoList insert(@RequestBody TodoListDTO todoListDTO){
        log.info("{}",todoListDTO);
        TodoList insert = todoService.insert(todoListDTO);
        return insert;
    }
    /**
     * 삭제
     */
    @PostMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id){
        todoService.delete(id);
        return HttpStatus.OK;
    }
    /**
     * 수정
     */
    @PutMapping("/update")
    public HttpStatus update(@RequestBody TodoListDTO todoListDTO){
        todoService.update(todoListDTO);
        return HttpStatus.OK;
    }
    @PostMapping("/do/{id}")
    public HttpStatus change_fini(@PathVariable Long id){
        todoService.change_fini(id);
        return HttpStatus.OK;
    }
    /**
     * 조회
     */
    @GetMapping
    public List<TodoList> findAll(){
        log.info("findAll");
        return todoService.findAll();
    }
    @GetMapping("/{id}")
    public TodoList findTodo(@PathVariable Long id){
        return todoService.findTodo(id);
    }
}
