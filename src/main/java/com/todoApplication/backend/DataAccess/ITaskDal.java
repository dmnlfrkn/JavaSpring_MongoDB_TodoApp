package com.todoApplication.backend.DataAccess;

import java.util.List;

import com.todoApplication.backend.Entities.Task;

public interface ITaskDal  {
	List<Task> getAll();
	void add(Task task);
	void update(Task task);
	void delete(int id);
	Task getById(int id);
}
