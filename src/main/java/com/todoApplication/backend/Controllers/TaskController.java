package com.todoApplication.backend.Controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.todoApplication.backend.Business.TaskManager;
import com.todoApplication.backend.Entities.Task;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class TaskController {
	
	@Autowired
	private TaskManager taskManager;
	
	@GetMapping("/tasks")
	public List<Task> getTasks(){
		return taskManager.getAll();
	}
	
	@PostMapping("/tasks")
	public Task addTask(@RequestBody Task task) {
		
		try {
			
			task.setId(taskManager.getSequenceNumber(Task.getSequenceName()));
			task.setDate(LocalDateTime.now().toString() );
			return taskManager.add(task);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@PutMapping("/tasks/{id}")
	public Task update(@RequestBody Task task, @PathVariable int id) {
		try {
			
			if(task.getId()==id) {
				task.setDate(LocalDateTime.now().toString());
				return taskManager.update(task);
			}
			else{
				throw new Exception("Path id and Task id cannot be matched");    	
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	@DeleteMapping("/tasks/{id}")
	public Task delete(@RequestBody Task task, @PathVariable int id) {
		try {
			if (task.getId() == id) {
				taskManager.delete(id);
				return task;
			}
			else {
				throw new Exception("Path id and Task id cannot be matched");    
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	@GetMapping("/tasks/{id}")
	public Task getByTasBykId(@PathVariable int id){
	return taskManager.getById(id);
	}
}
