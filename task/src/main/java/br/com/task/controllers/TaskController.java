package br.com.task.controllers;

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

import br.com.task.dtos.AvisoDTO;
import br.com.task.dtos.TaskDTO;
import br.com.task.services.TaskService;

@RestController
@RequestMapping("task")
public class TaskController  extends BaseController{

	@Autowired
	private TaskService taskService;

	@GetMapping("installation/{idinstallation}")
	public ResponseEntity<AvisoDTO> findByInstallation(@PathVariable String idinstallation) {
		try {
			return buildResponseRegistersSuccess(taskService.findByInstallation(idinstallation).stream().map(i -> i.toDTO())
					.collect(Collectors.toList()));
		} catch (Exception e) {
			return buildError(e);
		}
	}

	@PostMapping
	public ResponseEntity<AvisoDTO> created(@RequestBody TaskDTO taskDTO) {
		try {
			return buildCreateSuccess(taskService.create(taskDTO));
		} catch (Exception e) {
			return buildError(e, HttpStatus.EXPECTATION_FAILED); 
		}
	}
}
