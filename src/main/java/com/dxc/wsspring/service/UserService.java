package com.dxc.wsspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.wsspring.model.UserModel;
import com.dxc.wsspring.repositoy.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private  UserRepository userRepository;
	
//	//@Autowired
//	public UserService(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	public Iterable<UserModel> getUsers() {
		//log.info(recuperando todos os usuários);
		return userRepository.findAll();
	}
	
	public UserModel getUser(Integer id) {
		//log.info(recuperando usuário pelo id);
		return userRepository.findById(id).orElseThrow(() -> {
			return new RuntimeException(String.format("User=[%s] não foi encontrado", id));
		});
	}

	public UserModel createUser(String name, String email) {
		//log.info(criando um usuário);
		//builder e a contrução do objeto( uma cahamda no set do objeto)
		//UserModel user = UserModel.builder().name(name).email(email).build();
		UserModel user = null;
		return userRepository.save(user);
	}

	public UserModel updateUser(Integer id, String name, String email) {
		//log.info(Atualizando usuário pelo id);
		UserModel user = userRepository.findById(id).orElseThrow(() -> {
				return new RuntimeException(String.format("User=[%s] não foi encontrado", id));			
	});
		if (name != null) {
			user.setName(name);
		}
		
		if (email != null) {
			user.setEmail(email);
		}
		
		
		userRepository.save(user);
		
		return user;
	}

	public UserModel delete(Integer id) {
		//log.info(apagando usuário pelo id);
		UserModel user = userRepository.findById(id).orElseThrow(() -> {
			return new RuntimeException(String.format("User=[%s] não foi encontrado", id));
		});
		
		userRepository.deleteById(id);
		return  user;
	}

	public Iterable<UserModel> getUsersbyName(String name) {
		Iterable<UserModel> user  = userRepository.findByName(name);
		return user;
	}

}
