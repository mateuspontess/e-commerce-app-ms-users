package br.com.ecommerce.users.model;

import lombok.Getter;

@Getter
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone_number;
    private AddressDTO address;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone_number = user.getPhone_number();
        this.address = new AddressDTO(user.getAddress());
    }
}
