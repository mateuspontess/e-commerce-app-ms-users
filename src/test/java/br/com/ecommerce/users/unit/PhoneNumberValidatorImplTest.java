package br.com.ecommerce.users.unit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.ecommerce.users.annotation.PhoneNumberValidatorImpl;
import jakarta.validation.ConstraintValidatorContext;

@ExtendWith(MockitoExtension.class)
class PhoneNumberValidatorImplTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;
    @InjectMocks
    private PhoneNumberValidatorImpl phoneNumberImplementation;


    @Test
    @DisplayName("Valid phone number should return true")
    void testIsValid_withValidPhoneNumber() {
        String validPhoneNumber = "+5511999999999";
        assertTrue(phoneNumberImplementation.isValid(validPhoneNumber, constraintValidatorContext));
        String validPhoneNumber2 = "11999999999";
        assertTrue(phoneNumberImplementation.isValid(validPhoneNumber2, constraintValidatorContext));
    }

    @Test
    @DisplayName("Invalid phone number should return false")
    void testIsValid_withInvalidPhoneNumber() {
        String invalidPhoneNumber = "+551199999999"; // Invalid length
        assertFalse(phoneNumberImplementation.isValid(invalidPhoneNumber, constraintValidatorContext));
    }

    @Test
    @DisplayName("Null phone number should return false")
    void testIsValid_withNullPhoneNumber() {
        String nullPhoneNumber = null;
        assertFalse(phoneNumberImplementation.isValid(nullPhoneNumber, constraintValidatorContext));
    }

    @Test
    @DisplayName("Empty phone number should return false")
    void testIsValid_withEmptyPhoneNumber() {
        String emptyPhoneNumber = "";
        assertFalse(phoneNumberImplementation.isValid(emptyPhoneNumber, constraintValidatorContext));
    }

    @Test
    @DisplayName("Invalid format phone number should return false")
    void testIsValid_withInvalidFormatPhoneNumber() {
        String invalidFormatPhoneNumber = "not-a-phone-number";
        assertFalse(phoneNumberImplementation.isValid(invalidFormatPhoneNumber, constraintValidatorContext));
    }
}