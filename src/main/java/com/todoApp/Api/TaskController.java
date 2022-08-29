package com.todoApp.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoApp.DAL.TaskDal;
import com.todoApp.Model.Task;

@RestController
@RequestMapping("/api")
public class TaskController {

	 @Autowired
	private TaskDal taskDal ;
	
	@PostMapping("/add")
	public String addBook(@RequestBody Task task)
	{
		try {
			return taskDal.addTask(task);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@GetMapping("/tasks")
	public List<Task> getBooks(){
		
		return taskDal.getAll();
	}
	
	@GetMapping("/getByUsername/{userName}")
	public List<Task> getByTaskByUserName(@PathVariable String userName){
	return taskDal.getByUserName(userName);
	}
	
	@GetMapping("/getByState/{state}")
	public List<Task> getByTaskByState(@PathVariable String state){
	return taskDal.getByState(state);
	}

	
}
