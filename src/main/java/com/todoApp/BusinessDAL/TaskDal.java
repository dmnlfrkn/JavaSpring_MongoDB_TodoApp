package com.todoApp.BusinessDAL;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todoApp.Entities.Task;

@Service
public class TaskDal {

 @Autowired
 private TaskRepository TaskRepository;
 
 @Transactional
  public String addTask(Task task)
  {
	 try {
		  TaskRepository.save(task);
		  return "Task Added with id : " + task.getId();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 return e.getMessage();
	 }

  }
 
 @Transactional
 public String updateTask(Task task)
 {
	 try {
		  TaskRepository.save(task);
		  return "Task updated with id : " + task.getId();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 return e.getMessage();
	 }

 }
 
 @Transactional
 public String deleteTask(int id)
 {
	 try {
		  TaskRepository.deleteById(id); 
		  return "Task deleted";
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 return e.getMessage();
	 }

 }
  
	@Transactional
	public List<Task> getAll() {
		
		
		return ((List<Task>)this.TaskRepository.findAll());
	}
	
	@Transactional
	public List<Task> getByUserName(String username) {
		
		
		return ((List<Task>)this.TaskRepository.findByUsername(username));
	}
	
	@Transactional
	public List<Task> getByState(String state) {
		
		
		return ((List<Task>)this.TaskRepository.findByState(state));
	}
	
	@Transactional
	public Task getById(int id) {
		
		
		return (Task)this.TaskRepository.findById(id);
	}
  
}
