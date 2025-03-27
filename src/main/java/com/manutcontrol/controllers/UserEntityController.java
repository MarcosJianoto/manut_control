package com.manutcontrol.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manutcontrol.dto.UserEntityDTO;

import jakarta.validation.Valid;
import services.UsersEntityService;

@RestController
public class UserEntityController {

	@Autowired
	private UsersEntityService usersEntityService;

	public UserEntityController(UsersEntityService usersEntityService) {
		this.usersEntityService = usersEntityService;
	}

	@PostMapping("/user")
	public ResponseEntity<Void> createUser(@RequestBody @Valid UserEntityDTO user) {
		if (user == null || user.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		usersEntityService.createUser(user);
		return ResponseEntity.created(URI.create("/user/" + user.getEmail())).build();
	}

	@PutMapping("/user")
	public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody @Valid UserEntityDTO user) {
		if (user == null || user.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		usersEntityService.editUser(id, user);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserEntityDTO> getUser(@PathVariable Integer id) {

		UserEntityDTO user = usersEntityService.getUser(id);
		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserEntityDTO>> getUsers() {
		List<UserEntityDTO> users = usersEntityService.getAllUsers();
		return ResponseEntity.ok().body(users);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		usersEntityService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}
