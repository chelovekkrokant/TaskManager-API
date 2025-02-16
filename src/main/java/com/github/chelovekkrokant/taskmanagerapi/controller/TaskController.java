package com.github.chelovekkrokant.taskmanagerapi.controller;

import com.github.chelovekkrokant.taskmanagerapi.entity.Task;
import com.github.chelovekkrokant.taskmanagerapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping(value = "/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(value = "/tasks/{id}")
    public Optional<Task> getTaskById(@PathVariable(name = "id") Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping(value = "/tasks/today")
    List<Task> getTodayTasks(@RequestParam Boolean isCompleted){
        if (isCompleted != null) {
            return taskService.getTodayTasks(isCompleted);
        } else {
            return taskService.getTodayTasks();
        }
    }

    @GetMapping("/tasks/current-week")
    List<Task> getCurrentWeekTasks(@RequestParam Boolean isCompleted){
        if (isCompleted != null) {
            return taskService.getCurrentWeekTasks(isCompleted);
        } else {
            return taskService.getCurrentWeekTasks();
        }
    }

    @GetMapping("/tasks/current-month")
    List<Task> getCurrentMonthTasks(@RequestParam Boolean isCompleted){
        if (isCompleted != null) {
            return taskService.getCurrentMonthTasks(isCompleted);
        } else {
            return taskService.getCurrentMonthTasks();
        }
    }
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @PutMapping(value = "/tasks/{id}")
    public Task updateTask(@RequestBody Task taskDetails, @PathVariable(name = "id") Long id){
        return taskService.updateTask(id, taskDetails);
    }

    @PutMapping(value = "/tasks/{id}/status")
    public Task updateTaskCompleting(@RequestParam Boolean isCompleted, @PathVariable(name = "id") Long id){
        return taskService.updateTaskCompleting(id, isCompleted);
    }

    @DeleteMapping(value = "/tasks/{id}")
    public void deleteTask(@PathVariable(name = "id") Long id){
        taskService.deleteTask(id);
    }

}
