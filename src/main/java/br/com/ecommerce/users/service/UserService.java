package br.com.ecommerce.users.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.users.model.User;
import br.com.ecommerce.users.model.UserIdAndRoleDTO;
import br.com.ecommerce.users.model.UserResponseDTO;
import br.com.ecommerce.users.model.UserUpdateDTO;
import br.com.ecommerce.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private TokenService tokenService;
	
	
	public UserIdAndRoleDTO getUserByUsername(String token) {
		User user = this.getUserByToken(token);
		return new UserIdAndRoleDTO(user.getId(), user.getRole());
	}
	
	public UserResponseDTO updateUser(UserUpdateDTO dto, User user) {
		User update = mapper.map(dto, User.class);
		user.updateUser(update);
		return new UserResponseDTO(user);
	}
	
	public User getUserByToken(String token) {
		String username = tokenService.validateToken(token);
		return userRepository
				.findByUsername(username)
				.orElseThrow(EntityNotFoundException::new);
	}
}