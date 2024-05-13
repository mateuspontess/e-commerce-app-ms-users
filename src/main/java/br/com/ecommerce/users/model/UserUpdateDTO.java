package br.com.ecommerce.users.model;

import br.com.ecommerce.users.annotation.PhoneNumberValidator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class UserUpdateDTO {
	
    private final String name;
    private final String email;
    @PhoneNumberValidator
    private final String phone_number;
    private final AddressUpdateDTO address;
}