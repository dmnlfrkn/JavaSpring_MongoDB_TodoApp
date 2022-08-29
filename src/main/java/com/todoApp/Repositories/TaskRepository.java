package com.todoApp.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todoApp.Model.Task;

public interface TaskRepository extends MongoRepository<Task,Integer>{

public List<Task> findById(int id);

public List<Task> findByUsername(String username);

public List<Task> findByState(String state);

}
