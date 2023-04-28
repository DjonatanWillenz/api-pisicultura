package br.com.task;

public class TaskNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	TaskNotFoundException(String message) {
		super(message);
	}
}
