package br.com.ecommerce.users.unit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.ecommerce.users.controller.UserController;
import br.com.ecommerce.users.model.Address;
import br.com.ecommerce.users.model.AddressDTO;
import br.com.ecommerce.users.model.User;
import br.com.ecommerce.users.model.UserUpdateDTO;
import br.com.ecommerce.users.service.UserService;

@WebMvcTest(UserController.class)
@AutoConfigureJsonTesters
class UserControllerUnitTest {
	
	@MockBean
	private UserService service;
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private JacksonTester<UserUpdateDTO> userUpdateDTOJson;

	@Test
	@DisplayName("Update user - should return status 200")
	void updateUserTest01() throws IOException, Exception {
		// arrange
		UserUpdateDTO requestBody = new UserUpdateDTO("update name", "update@email.com", null, new AddressDTO());
		
		User userMock = User.builder().name("user").email("user@email.com").phone_number("(11) 11111-1111)").address(new Address()).build();
		when(service.getUserByToken(any())).thenReturn(userMock);

		// act and assert
		mvc.perform(
			put("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(userUpdateDTOJson.write(requestBody).getJson())
				.header("Authorization", "Bearer token")
			)
			.andExpect(status().isOk())
			.andReturn().getResponse();

		verify(service).getUserByToken(anyString());
		verify(service).updateUser(any(), any());
	}
	
	@Test
	@DisplayName("Update user - should return status 400")
	void updateUserTest02() throws IOException, Exception {
		// arrange
		UserUpdateDTO requestBody = new UserUpdateDTO("update name", "update@email.com", null, new AddressDTO());
		
		User userMock = User.builder().name("user").email("user@email.com").phone_number("(11) 11111-1111)").address(new Address()).build();
		when(service.getUserByToken(any())).thenReturn(userMock);

		// act and assert
		mvc.perform(
			put("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(userUpdateDTOJson.write(requestBody).getJson())
				// missing Authorization header
			)
			.andExpect(status().isBadRequest());

		verifyNoInteractions(service);
	}
}