package com.github.chelovekkrokant.taskmanagerapi.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task{

    public Task() {
    }

    public Task(Task task) {
        this.id = task.id;
        this.title = task.title;
        this.description = task.description;
        this.completed = task.completed;
        this.creationDate = task.creationDate;
    }

    public Task(Task task, Boolean isCompleted) {
        this.id = task.id;
        this.title = task.title;
        this.description = task.description;
        this.completed = isCompleted;
        this.creationDate = task.creationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean completed;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
}
