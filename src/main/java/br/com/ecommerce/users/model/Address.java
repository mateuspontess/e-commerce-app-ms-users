package br.com.ecommerce.users.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Address {
	
	private String street;
	private String neighborhood;
	private String postal_code;
	private String number;
	private String complement;
	private String city;
	private String state;
	
	
	public void updateEndereco(Address updatedData) {
	    if (updatedData != null && !updatedData.getStreet().isBlank()) {
	        this.street = updatedData.getStreet();
	    }
	    if (updatedData != null && !updatedData.getNeighborhood().isBlank()) {
	        this.neighborhood = updatedData.getNeighborhood();
	    }
	    if (updatedData != null && !updatedData.getPostal_code().isBlank()) {
	        this.postal_code = updatedData.getPostal_code();
	    }
	    if (updatedData != null && !updatedData.getNumber().isBlank()) {
	        this.number = updatedData.getNumber();
	    }
	    if (updatedData != null && !updatedData.getComplement().isBlank()) {
	        this.complement = updatedData.getComplement();
	    }
	    if (updatedData != null && !updatedData.getCity().isBlank()) {
	        this.city = updatedData.getCity();
	    }
	    if (updatedData != null && !updatedData.getState().isBlank()) {
	        this.state = updatedData.getState();
	    }
	}
}