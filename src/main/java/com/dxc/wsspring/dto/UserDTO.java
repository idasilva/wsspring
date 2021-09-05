package com.dxc.wsspring.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Essa classe ajudará a definir os objetos.
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	@NotBlank
	private String name;
		
	@NotBlank
	private String email;

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
