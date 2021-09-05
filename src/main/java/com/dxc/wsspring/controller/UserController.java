package com.dxc.wsspring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.wsspring.dto.UserDTO;
import com.dxc.wsspring.model.UserModel;
import com.dxc.wsspring.service.UserService;

//Responsável por fazer o mapeamento das rotas.
@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	
	//Responsável por manipulação de banco // injeção de dependencia o spring que vai setar a instancia
	@Autowired 
	private  UserService   userService;
	
	@GetMapping
	public ResponseEntity<Iterable<UserModel>> getUsers(@RequestParam(value = "name", defaultValue = "") String name){
		Iterable<UserModel> users = null;
		if(name.isEmpty())
			users = userService.getUsers();
		else
			users = userService.getUsersbyName(name);
		
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<UserModel> getUser(@PathVariable Integer id){
		UserModel user = userService.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<UserModel> createUser(@RequestBody @Valid UserDTO userDTO){
		UserModel user = userService.createUser(userDTO.getName(), userDTO.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<UserModel> createUser(@PathVariable Integer id, @RequestBody @Valid UserDTO userDTO){
		UserModel user = userService.updateUser(id, userDTO.getName(), userDTO.getEmail());
		return  ResponseEntity.ok(user);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserModel> deleteUser(@PathVariable Integer id){
		UserModel user = userService.delete(id);
		return ResponseEntity.ok(user);
		
	}
	
	
}
