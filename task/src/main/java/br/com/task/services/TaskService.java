package br.com.task.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.task.dtos.TaskCreateDTO;
import br.com.task.dtos.TaskDTO;
import br.com.task.enums.ResponseEnum;
import br.com.task.exceptions.DataValidatorException;
import br.com.task.exceptions.RegisterNotFoundException;
import br.com.task.models.Task;
import br.com.task.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> findByInstallation(String id) {
		return taskRepository.findByIdinstallation(id);
	}

	public Task findById(String id) throws RegisterNotFoundException {
		return this.taskRepository.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException("Register not found.", ResponseEnum.ERROR));
	}

	@Transactional
	public TaskDTO create(TaskCreateDTO taskDTO) throws DataValidatorException {
		if (taskDTO.getIdinstallation() == null)
			throw new DataValidatorException("Field {idinstallation} required.", ResponseEnum.WARNING);

		Task task = Task.builder().dateCreate(new Date()).description(taskDTO.getDescription())
				.idinstallation(taskDTO.getIdinstallation()).build();
		return taskRepository.save(task).toDTO();
	}
	
	@Transactional 
	public void deleteByID(String id)  {
		this.taskRepository.deleteById(id);
	}
}
