package com.demo.mongodb.mongodemo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mongodb.mongodemo.model.Task;
import com.demo.mongodb.mongodemo.repository.TaskRepository;

@Service
public class TaskService {
	
	

	@Autowired
	private TaskRepository taskRepository;
	
	//CRUD create, read, update, delete
	
	public Task addTask(Task task)
	{
	   task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
	   return taskRepository.save(task);
	}
	
	public List<Task> findAllTasks()
	{
		return taskRepository.findAll();
	}
	
	public Task getTaskByTaskId(String taskId)
	{
		return taskRepository.findById(taskId).get();
	}
	
	public List<Task> getTaskBySeverity(int severity){
	
		return taskRepository.findBySeverity(severity);
	}
	
	public List<Task> getTaskByAssignee(String assignee){
		
		return taskRepository.getByAssignee(assignee);
	}
	
	public Task updatedTask(Task taskRequest)
	{
		Task existingTask=taskRepository.findById(taskRequest.getTaskId()).get();
		existingTask.setDescription(taskRequest.getDescription());
		existingTask.setSeverity(taskRequest.getSeverity());
		existingTask.setAssignee(taskRequest.getAssignee());
		existingTask.setStoryPoint(taskRequest.getStoryPoint());
		
		return taskRepository.save(existingTask);
	}
	
	public String deleteTask(String taskId)
	{
		taskRepository.deleteById(taskId);
		return "Task deleted from dahsboard " +taskId;
	}
}
