package com.todoApp.restApi;

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

import com.todoApp.BusinessDAL.TaskDal;
import com.todoApp.Entities.Task;

@RestController
@RequestMapping("/api")
public class TaskController {

	 @Autowired
	private TaskDal taskDal ;
		 
	@PostMapping("/tasks")
	public String addTask(@RequestBody Task task)
	{
		try {
<<<<<<< HEAD
<<<<<<< HEAD
			task.setId(taskDal.getSequenceNumber(Task.getSequenceName()));
			task.setDate(LocalDateTime.now().toString() );
=======
>>>>>>> parent of b9415db (Mongodb Auto Incremented Id)
=======
>>>>>>> parent of b9415db (Mongodb Auto Incremented Id)
			return taskDal.addTask(task);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@PutMapping("/tasks")
	public String updateTask(@RequestBody Task task)
	{
		try {
			return taskDal.updateTask(task);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@DeleteMapping("/tasks")
	public String deleteTask(@RequestBody int id)
	{
		try {
			return taskDal.deleteTask(id);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@GetMapping("/tasks")
	public List<Task> getTasks(){
			return taskDal.getAll();
	}
	
	@GetMapping("/tasks/{id}")
	public Task getByTasBykId(@PathVariable int id){
	return taskDal.getById(id);
	}
	/*
	@GetMapping("/tasks/{userName}")
	public List<Task> getByTaskByUserName(@PathVariable String userName){
	return taskDal.getByUserName(userName);
	}
	*/
	/*
	@GetMapping("/tasks/{state}")
	public List<Task> getByTaskByState(@PathVariable String state){
	return taskDal.getByState(state);
	}
	 */
	
}
