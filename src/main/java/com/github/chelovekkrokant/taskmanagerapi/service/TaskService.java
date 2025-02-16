package com.github.chelovekkrokant.taskmanagerapi.service;

import com.github.chelovekkrokant.taskmanagerapi.entity.Task;
import com.github.chelovekkrokant.taskmanagerapi.repository.TaskRepository;
import static com.github.chelovekkrokant.taskmanagerapi.util.DateUtil.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        if (taskRepository.existsById(id)) {
            return taskRepository.save(new Task(task));
        } else throw new RuntimeException("Task " + id + " was not found");
    }

    /**
     * Удаление задачи.
     */
    public void deleteTask(Long id){
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        } else throw new RuntimeException("Task " + id + " was not found");
    }

    /**
     * Отметка задачи в качестве выполненной.
     */
    public Task updateTaskCompleting(Long id, Boolean isCompleted){
        Task task = taskRepository.findById(id).orElseThrow();
        return taskRepository.save(new Task(task, isCompleted));
    }

    /**
     * Задачи на данный день.
     */
    public List<Task> getTodayTasks(Boolean isCompleted){
        Date startOfDay = getStartOfDay();
        Date endOfDay = getEndOfDay();
        return taskRepository.findByCreationDateBetweenAndCompleted(startOfDay, endOfDay, isCompleted);
    }

    public List<Task> getTodayTasks(){
        Date startOfDay = getStartOfDay();
        Date endOfDay = getEndOfDay();
        return taskRepository.findByCreationDateBetween(startOfDay, endOfDay);
    }

    /**
     * Задачи на данную неделю.
     */
    public List<Task> getCurrentWeekTasks(Boolean isCompleted){
        Date startOfWeek = getStartOfWeek();
        Date endOfDay = getEndOfDay();
        return taskRepository.findByCreationDateBetweenAndCompleted(startOfWeek, endOfDay, isCompleted);
    }

    public List<Task> getCurrentWeekTasks(){
        Date startOfWeek = getStartOfWeek();
        Date endOfDay = getEndOfDay();
        return taskRepository.findByCreationDateBetween(startOfWeek, endOfDay);
    }

    /**
     * Задачи на данный месяц.
     */
    public List<Task> getCurrentMonthTasks(Boolean isCompleted){
        Date startOfMonth = getStartOfMonth();
        Date endOfDay = getEndOfDay();
        return taskRepository.findByCreationDateBetweenAndCompleted(startOfMonth, endOfDay, isCompleted);
    }

    public List<Task> getCurrentMonthTasks(){
        Date startOfMonth = getStartOfMonth();
        Date endOfDay = getEndOfDay();
        return taskRepository.findByCreationDateBetween(startOfMonth, endOfDay);
    }


}
