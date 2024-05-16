package br.com.ecommerce.users.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.users.exception.InvalidTokenException;
import br.com.ecommerce.users.model.User;
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
	
	
	public UserResponseDTO getUserByUsername(String token) {
		User user = this.getUserByToken(token);

		return new UserResponseDTO(user.getId(), user.getRole());
	}
	
	public void updateUser(UserUpdateDTO dto, User user) {
		User update = mapper.map(dto, User.class);
		user.updateUser(update);
		
		userRepository.flush();
	}
	
	public User getUserByToken(String token) {
		String username = tokenService.validateToken(token);
		if (username == null || username.isBlank()) 
			throw new InvalidTokenException("");			
		
		return userRepository
				.findByUsername(username)
				.orElseThrow(EntityNotFoundException::new);
	}
}