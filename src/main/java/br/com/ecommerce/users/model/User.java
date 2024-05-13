package br.com.ecommerce.users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "User")
@Table(name = "users")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String phone_number;
	
	@Column(unique = true)
	private String cpf;

	@Embedded
	private Address address;

	@Enumerated(EnumType.STRING)
	private UserRole role;

	
	public void updateUser(User updatedData) {
		if (updatedData != null) {
			if (updatedData != null && !updatedData.getName().isBlank()) {
				this.name = updatedData.getName();
			}
			if (updatedData != null && !updatedData.getEmail().isBlank()) {
				this.email = updatedData.getEmail();
			}
			if (updatedData != null && !updatedData.getPhone_number().isBlank()) {
				this.phone_number = updatedData.getPhone_number();
			}

			if (this.address != null)
				this.address.updateEndereco(updatedData.getAddress());
		}
	}
}