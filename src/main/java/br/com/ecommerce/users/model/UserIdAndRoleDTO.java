package br.com.ecommerce.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserIdAndRoleDTO {
	
	private Long id;
	private UserRole role;
}