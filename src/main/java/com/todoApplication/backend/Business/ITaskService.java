package com.todoApplication.backend.Business;

import java.util.List;

import com.todoApplication.backend.Entities.Task;

public interface ITaskService {
	List<Task> getAll();
	void add(Task task);
	void update(Task task);
	void delete(int id);
	Task getById(int id);
}
