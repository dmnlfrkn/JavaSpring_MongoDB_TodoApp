package com.todoApplication.backend.DataAccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.todoApplication.backend.Entities.Task;

public class MongodbTaskDal implements ITaskDal {
	
	
	
	@Autowired
	private ITaskRepo taskRepo;
	
	@Override
	@Transactional
	public List<Task> getAll() {
		// TODO Auto-generated method stub
		return ((List<Task>)this.taskRepo.findAll());
	}

	@Override
	public void add(Task task) {
		try {
			taskRepo.save(task);
			System.out.println("Task Added with id : " + task.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public void update(Task task) {
		try {
			 taskRepo.save(task);
			 System.out.println("Task updated with id : " + task.getId());
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }
		
	}

	@Override
	public void delete(int id) {
		try {
			  taskRepo.deleteById(id); 
			  System.out.println("Task deleted"+ id);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }
		
	}

	@Override
	public Task getById(int id) {
		
		return (Task)this.taskRepo.findById(id);
	}

}
