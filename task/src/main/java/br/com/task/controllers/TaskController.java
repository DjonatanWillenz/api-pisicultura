package br.com.task.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.task.dtos.ResponseDTO;
import br.com.task.dtos.TaskCreateDTO;
import br.com.task.models.Task;
import br.com.task.services.TaskService;

@RestController
@RequestMapping("task")
public class TaskController extends BaseController {

	@Autowired
	private TaskService taskService;

	@GetMapping("{id}")
	public ResponseEntity<ResponseDTO> findById(@PathVariable String id) {
		try {
			Task task = taskService.findById(id);
			return buildResponseRegistersSuccess(task);
		} catch (Exception e) {
			return buildError(e, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("installation/{idinstallation}")
	public ResponseEntity<ResponseDTO> findByInstallation(@PathVariable String idinstallation) {
		try {
			return buildResponseRegistersSuccess(taskService.findByInstallation(idinstallation).stream()
					.map(i -> i.toDTO()).collect(Collectors.toList()));
		} catch (Exception e) {
			return buildError(e);
		}
	}

	@PostMapping
	public ResponseEntity<ResponseDTO> created(@RequestBody TaskCreateDTO taskDTO) {
		try {
			return buildCreateSuccess(taskService.create(taskDTO));
		} catch (Exception e) {
			return buildError(e, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ResponseDTO>  deleteById(@PathVariable String id) {
		try {
		return buildDeleteSuccess();
		} catch (Exception e) {
	return	 buildError(e);	
		}
	}
}
