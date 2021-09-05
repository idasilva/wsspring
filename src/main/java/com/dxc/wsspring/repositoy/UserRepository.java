package com.dxc.wsspring.repositoy;

import org.springframework.data.repository.CrudRepository;

import com.dxc.wsspring.model.UserModel;

//podemos reutilizar metodos já existente na classe extendida, se for um cenário bem especifico precisaremos declarar como no exemplo abaixo
public interface UserRepository extends CrudRepository<UserModel, Integer>{
	Iterable<UserModel> findByName(String name);

}
