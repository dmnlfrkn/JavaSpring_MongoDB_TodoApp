package com.todoApp.BusinessDAL;

import java.util.List;


import java.util.Objects;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todoApp.Entities.DbSequence;
import com.todoApp.Entities.Task;

@Service
public class TaskDal {

 @Autowired
 private TaskRepository TaskRepository;
 
 @Autowired
 private MongoOperations mongoOperations;
 
 public int getSequenceNumber(String sequenceName) {
	 
	 //get squence_no
	 Query query = new Query(Criteria.where("id").is(sequenceName));
	 //update sequence_no
	 Update update = new Update().inc("seq", 1);
	 //modify in document
	 DbSequence counter = mongoOperations
			 .findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(true), DbSequence.class);
	 return !Objects.isNull(counter) ? counter.getSeq() : 1;
	 
}
 
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
		  return "Task deleted"+ id;
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
