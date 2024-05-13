package br.com.ecommerce.users.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class UserResponseDTO {
	
	private final Long id;
	private final UserRole role;
}