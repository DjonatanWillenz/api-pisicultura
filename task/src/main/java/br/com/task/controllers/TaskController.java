package br.com.task.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.task.dtos.ResponseDTO;
import br.com.task.dtos.TaskDTO;
import br.com.task.services.TaskService;

@RestController
@RequestMapping("task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping("installation/{idinstallation}")
	public ResponseEntity<Serializable> findByInstallation(@PathVariable String idinstallation) {
		List<TaskDTO> tasks = taskService.findByInstallation(idinstallation).stream().map(i -> i.toDTO())
				.collect(Collectors.toList());
		return ResponseEntity.ok(ResponseDTO.builder().countRegister(tasks.size()).data(tasks).build());
	}
	
	@PostMapping
	public ResponseEntity<Serializable> created(@RequestBody TaskDTO taskDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(taskDTO));
	}
}
