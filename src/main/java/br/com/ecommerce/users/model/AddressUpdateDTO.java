package br.com.ecommerce.users.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AddressUpdateDTO {
    private final String street;
    private final String neighborhood;
    private final String postal_code;
    private final String number;
    private final String complement;
    private final String city;
    private final String state;
}