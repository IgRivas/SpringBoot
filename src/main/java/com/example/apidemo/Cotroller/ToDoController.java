package com.example.apidemo.Cotroller;

import com.example.apidemo.Model.Task_Entidad;
import com.example.apidemo.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/")
    public String holaMundo(){
        return "Hola mundo!!";
    }
    @GetMapping("/tasks")
    public List<Task_Entidad> getTasks(){
        return toDoRepository.findAll();
    }
    @PostMapping("/savetasks")
    public String saveTasks(@RequestBody Task_Entidad task){
        toDoRepository.save(task);
        return "Saved task";
    }
    @PutMapping("/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task_Entidad task){
        Task_Entidad updatedTask = toDoRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescripcion(task.getDescripcion());
        toDoRepository.save(updatedTask);
        return "Updated Task";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task_Entidad deletedTask = toDoRepository.findById(id).get();
        toDoRepository.delete(deletedTask);
        return "Deleted Task";

    }
}
