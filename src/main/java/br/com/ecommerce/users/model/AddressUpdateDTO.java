package br.com.ecommerce.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressUpdateDTO {
    
    private String street;
    private String neighborhood;
    private String postal_code;
    private String number;
    private String complement;
    private String city;
    private String state;
}