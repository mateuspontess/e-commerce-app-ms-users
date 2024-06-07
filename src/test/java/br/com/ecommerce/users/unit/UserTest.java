package br.com.ecommerce.users.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.ecommerce.users.model.User;

class UserTest {

	@Test
	@DisplayName("Test updating user with valid data")
	void updateUserTest01() {
		// arrange
		User target = User.builder()
			.name("default")
			.email("default@email.com")
			.phone_number("1111111111111")
			.build();

		User updateData = User.builder()
			.name("Name updated")
			.email("update@email.com")
			.phone_number("2222222222222")
			.build();

		// act
		target.updateUser(updateData);

		// assert
		assertEquals(updateData.getName(), target.getName());
		assertEquals(updateData.getEmail(), target.getEmail());
		assertEquals(updateData.getPhone_number(), target.getPhone_number());
	}
	
	@Test
	@DisplayName("Test updating user with null values")
	void updateUserTest02() {
		// arrange
		User target = User.builder()
			.name("default")
			.email("default@email.com")
			.phone_number("1111111111111")
			.build();

		User updateData = User.builder()
			.name(null)
			.email(null)
			.phone_number(null)
			.build();

		// act
		target.updateUser(updateData);

		// assert
		assertNotEquals(updateData.getName(), target.getName());
		assertNotEquals(updateData.getEmail(), target.getEmail());
		assertNotEquals(updateData.getPhone_number(), target.getPhone_number());
	}
	
	@Test
	@DisplayName("Test updating user with empty strings")
	void updateUserTest03() {
		// arrange
		User target = User.builder()
			.name("default")
			.email("default@email.com")
			.phone_number("1111111111111")
			.build();
			
		User updateData = User.builder()
			.name("")
			.email("")
			.phone_number("")
			.build();
		
		// act
		target.updateUser(updateData);
		
		// assert
		assertNotEquals(updateData.getName(), target.getName());
		assertNotEquals(updateData.getEmail(), target.getEmail());
		assertNotEquals(updateData.getPhone_number(), target.getPhone_number());
	}
}