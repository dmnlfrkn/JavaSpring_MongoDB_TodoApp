package com.todoApp.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "tasks")
public class Task {
	
	@Transient
	private static final String SEQUENCE_NAME = "user_sequence";
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	
	
	
	
	@Id
	private int id;
	private String username ;
	private String taskText;
	private String state;
	private String date;
	
	

	public Task(int id, String username, String taskText,String state) {
		
		this.id = id;
		this.username = username;
		this.taskText = taskText;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTaskText() {
		return taskText;
	}

	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}



