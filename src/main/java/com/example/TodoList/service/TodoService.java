package com.example.TodoList.service;

import com.example.TodoList.domain.TodoList;
import com.example.TodoList.domain.TodoListDTO;
import com.example.TodoList.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    /**
     * 삽입
     * @param todoList
     * @return
     */
    public TodoList insert(TodoListDTO todoListDTO){
        TodoList todoList = new TodoList(todoListDTO.getContents());
        TodoList save = todoRepository.save(todoList);
        return save;
    }

    /**
     * 삭제
     * @param todoList
     */

    public void delete(Long id){
        TodoList findTodo = todoRepository.findById(id).orElseThrow(()->{
            throw new RuntimeException("Does not exist");
        });
        todoRepository.delete(findTodo);
    }

    /**
     * 수정
     * @param todoList
     */
    @Transactional
    public void update(TodoListDTO todoListDTO){
        TodoList todoList = new TodoList(todoListDTO.getContents());
        TodoList findTodo = todoRepository.findById(todoList.getId()).orElseThrow(()->{
            throw new RuntimeException("Does not exist");
        });
        findTodo.setContents(todoList.getContents());
    }
    @Transactional
    public void change_fini(Long id){
        TodoList todo = findTodo(id);
        int finish = todo.getFinish();
        finish = finish == 0 ? 1 : 0;
        todo.setFinish(finish);
    }
    /**
     * 조회
     */
    public TodoList findTodo(Long id){
        TodoList findTodo = todoRepository.findById(id).orElseThrow(()->{
            throw new RuntimeException("Does not exist");
        });
        return findTodo;
    }
    public List<TodoList> findAll(){
        return todoRepository.findAll();
    }
}
