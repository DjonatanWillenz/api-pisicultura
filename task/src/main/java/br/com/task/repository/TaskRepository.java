package br.com.task.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.task.models.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByIdinstallation(String idinstallation);
}
