package com.demo.mongodb.mongodemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mongodb.mongodemo.model.Task;
import com.demo.mongodb.mongodemo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Task createTask(@RequestBody Task task)
	{
		return service.addTask(task);
	}
	
	@GetMapping
	public List<Task> findAllTasks()
	{
		return service.findAllTasks();
	}
	
	@GetMapping("/{taskId}")
	public Task getTaskByTaskId(@PathVariable String taskId)
	{
		return service.getTaskByTaskId(taskId);
	}
 	
	
	@GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee){
		
		return service.getTaskByAssignee(assignee);
	}
	
	@GetMapping("/severity/{severity}")
	public List<Task> getTaskBySeverity(@PathVariable int severity){
		
		return service.getTaskBySeverity(severity);
	}
	
	@PatchMapping
	public Task updateTask(@RequestBody Task task)
	{
		return service.updatedTask(task);
	}
	
	@DeleteMapping("/{taskId}")
	public String deleteTask(@PathVariable  String taskId)
	{
		return service.deleteTask(taskId);
	}
	
	
	
	
}
