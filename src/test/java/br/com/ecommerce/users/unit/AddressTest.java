package br.com.ecommerce.users.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.ecommerce.users.model.Address;

class AddressTest {

	@Test
	@DisplayName("Test updating address with identical data")
	void updateAddress01() {
		// arrange
		Address target = Address.builder()
			.street("street")
			.neighborhood("neighborhood")
			.postal_code("postal_code")
			.number("number")
			.complement("complement")
			.city("city")
			.state("state")
			.build();

		Address updateData = Address.builder()
			.street("street")
			.neighborhood("neighborhood")
			.postal_code("postal_code")
			.number("number")
			.complement("complement")
			.city("city")
			.state("state")
			.build();

		// act
		target.updateAddress(updateData);

		// assert
		assertEquals(updateData.getStreet(), target.getStreet());
		assertEquals(updateData.getNeighborhood(), target.getNeighborhood());
		assertEquals(updateData.getPostal_code(), target.getPostal_code());
		assertEquals(updateData.getNumber(), target.getNumber());
		assertEquals(updateData.getComplement(), target.getComplement());
		assertEquals(updateData.getCity(), target.getCity());
		assertEquals(updateData.getState(), target.getState());
	}

	@Test
	@DisplayName("Test updating address with null values")
	void updateAddress02() {
		// arrange
		Address target = Address.builder()
			.street("street")
			.neighborhood("neighborhood")
			.postal_code("postal_code")
			.number("number")
			.complement("complement")
			.city("city")
			.state("state")
			.build();

		Address updateData = Address.builder()
			.street(null)
			.neighborhood(null)
			.postal_code(null)
			.number(null)
			.complement(null)
			.city(null)
			.state(null)
			.build();

		// act
		target.updateAddress(updateData);

		// assert
		assertNotEquals(updateData.getStreet(), target.getStreet());
		assertNotEquals(updateData.getNeighborhood(), target.getNeighborhood());
		assertNotEquals(updateData.getPostal_code(), target.getPostal_code());
		assertNotEquals(updateData.getNumber(), target.getNumber());
		assertNotEquals(updateData.getComplement(), target.getComplement());
		assertNotEquals(updateData.getCity(), target.getCity());
		assertNotEquals(updateData.getState(), target.getState());
	}

	@Test
	@DisplayName("Test updating address with empty strings")
	void updateAddress03() {
		// arrange
		Address target = Address.builder()
			.street("street")
			.neighborhood("neighborhood")
			.postal_code("postal_code")
			.number("number")
			.complement("complement")
			.city("city")
			.state("state")
			.build();

		Address updateData = Address.builder()
			.street("")
			.neighborhood("")
			.postal_code("")
			.number("")
			.complement("")
			.city("")
			.state("")
			.build();

		// act
		target.updateAddress(updateData);

		// assert
		assertNotEquals(updateData.getStreet(), target.getStreet());
		assertNotEquals(updateData.getNeighborhood(), target.getNeighborhood());
		assertNotEquals(updateData.getPostal_code(), target.getPostal_code());
		assertNotEquals(updateData.getNumber(), target.getNumber());
		assertNotEquals(updateData.getComplement(), target.getComplement());
		assertNotEquals(updateData.getCity(), target.getCity());
		assertNotEquals(updateData.getState(), target.getState());
	}
}