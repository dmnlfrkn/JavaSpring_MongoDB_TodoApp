package com.todoApplication.backend.DataAccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todoApplication.backend.Entities.Task;

public interface ITaskRepo extends MongoRepository<Task,Integer> {
	public Task findById(int id);
}
