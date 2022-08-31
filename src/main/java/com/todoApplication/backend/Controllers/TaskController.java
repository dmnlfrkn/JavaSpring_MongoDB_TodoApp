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

import com.todoApplication.backend.Business.TaskManager;
import com.todoApplication.backend.Entities.Task;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskManager taskManager;
	
	@GetMapping("/tasks")
	public List<Task> getTasks(){
		return taskManager.getAll();
	}
	
	@PostMapping("/tasks")
	public void addTask(@RequestBody Task task) {
		
		try {
			if(task.getState().toLowerCase().equals("todo") ||
			   task.getState().toLowerCase().equals("in progress") ||
			   task.getState().toLowerCase().equals("done")) {
				task.setId(taskManager.getSequenceNumber(Task.getSequenceName()));
				task.setDate(LocalDateTime.now().toString() );
				taskManager.add(task);
			}
			else {
				System.out.println("hatalı state girildi...!!");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@PutMapping("/tasks")
	public void update(@RequestBody Task task) {
		try {
			if(task.getState().toLowerCase().equals("todo") ||
					   task.getState().toLowerCase().equals("in progress") ||
					   task.getState().toLowerCase().equals("done")) {
						task.setDate(LocalDateTime.now().toString());
						taskManager.update(task);
					}
					else {
						System.out.println("hatalı state girildi...!!");
					}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@DeleteMapping("/tasks")
	public void delete(@RequestBody int id) {
		try {
			taskManager.delete(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@GetMapping("/tasks/{id}")
	public Task getByTasBykId(@PathVariable int id){
	return taskManager.getById(id);
	}
}