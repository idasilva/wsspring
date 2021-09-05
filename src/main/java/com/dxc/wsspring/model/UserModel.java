package com.dxc.wsspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	@Id
	@GeneratedValue	
	private Integer  id;
	@NotEmpty(message = "Nome não pode ser vazio")
	private String name;
	@Email(message = "seu email nao é valido, por favor digite um e-mail valido")
	@NotEmpty(message = "Nome não pode ser vazio")
	private String email;
	public void setName(String name2) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(String email2) {
		// TODO Auto-generated method stub
		
	}
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

}
