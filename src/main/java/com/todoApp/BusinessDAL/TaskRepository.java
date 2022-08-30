package com.todoApp.BusinessDAL;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todoApp.Entities.Task;


public interface TaskRepository extends MongoRepository<Task,Integer>{

public Task findById(int id);

public List<Task> findByUsername(String username);

public List<Task> findByState(String state);

}
