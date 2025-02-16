package com.github.chelovekkrokant.taskmanagerapi.repository;

import com.github.chelovekkrokant.taskmanagerapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     *
     * @param creationDate
     * @param competingDate
     * @param isCompleted
     * @Goal:
     * Поиск выполненных задач за указанный период.
     *
     */
    List<Task> findByCreationDateBetweenAndCompleted(Date creationDate, Date competingDate, Boolean isCompleted);

    /**
     *
     * @param creationDate
     * @param competingDate
     * @Goal:
     * Поиск задач за указанный период.
     *
     */
    List<Task> findByCreationDateBetween(Date creationDate, Date competingDate);
}
