package com.todoApplication.backend.Business;

import java.util.List;

import com.todoApplication.backend.Entities.Task;

public interface ITaskService {
	List<Task> getAll();
	Task add(Task task);
	Task update(Task task);
	Task delete(int id);
	Task getById(int id);
}
