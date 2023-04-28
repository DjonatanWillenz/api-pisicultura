package br.com.task.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.task.models.Task;
import br.com.task.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> findByInstallation(String id) {
		return taskRepository.findByInstallation(id);
	}

}
