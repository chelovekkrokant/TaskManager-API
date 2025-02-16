package com.github.chelovekkrokant.taskmanagerapi.taskManagerAPI;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplicationpublic 
@EntityScan("com/github/chelovekkrokant/taskmanagerapi/entity/Task.java")
class TaskManagerAPI {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerAPI.class, args);
    }

}
