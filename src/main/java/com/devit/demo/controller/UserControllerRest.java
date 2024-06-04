package com.devit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devit.demo.entitys.Books;
import com.devit.demo.entitys.Users;
import com.devit.demo.repository.UserRepository;

@RestController
@RequestMapping("demo_user/")
public class UserControllerRest {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("all")
	public List<Users> getAll(){
		return (List<Users>) userRepository.findAll();
	}
	
	@PostMapping("new")
	public Users newUser(@RequestBody Users user){
		Users userNew = new Users();
		try {
			if (user.getEmail().isEmpty())
				throw new Exception("El campo E-Mail esta nulo");
			else 
				userNew = userRepository.save(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userNew;
	}
	
	@PutMapping("edit")
	public Users editUser(@RequestBody Users userEdit, @PathVariable Long id){
		Users usersUpdate = new Users();
		try {
			usersUpdate = userRepository.findById(id).get();
			usersUpdate.setEmail(userEdit.getEmail());
			usersUpdate.setUserName(userEdit.getUserName());
			userRepository.save(usersUpdate);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return usersUpdate;
	}
	
	@DeleteMapping("delete")
	public void deleteUser(@PathVariable Long id){
		try {
			//Eliminar el registro
			userRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
