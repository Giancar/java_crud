package com.listatodo.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ToDoController {
	
	@Autowired
	ToDoRepository repository;
	
	@GetMapping("/todo")
	public List<ToDo> getAllToDo() {
		return	repository.findAll();
	}
	
	@GetMapping("/todo/{id}")
	public ToDo getToDoById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/todo")
	public ToDo saveToDo(@RequestBody ToDo  todo) {
		return repository.save(todo);
	}
	
	@DeleteMapping("/todo/{id}")
	public void deleteToDo(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
