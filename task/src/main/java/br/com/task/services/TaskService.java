package br.com.task.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.task.dtos.TaskDTO;
import br.com.task.enums.AvisoEnum;
import br.com.task.exceptions.DataValidatorException;
import br.com.task.models.Task;
import br.com.task.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> findByInstallation(String id) {
		return taskRepository.findByIdinstallation(id);
	}

	@Transactional
	public TaskDTO create(TaskDTO taskDTO) throws DataValidatorException {
		if (taskDTO.getIdinstallation() == null)
			throw new DataValidatorException("Field {idinstallation} required.", AvisoEnum.WARNING);

		Task task = Task.builder().dateCreate(new Date()).description(taskDTO.getDescription())
				.idinstallation(taskDTO.getIdinstallation()).build();
		return taskRepository.save(task).toDTO();
	}
}
