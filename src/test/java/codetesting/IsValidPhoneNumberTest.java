package codetesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class IsValidPhoneNumberTest {

    public boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\+\\d{1,3} \\d{10}");
    }

    @ParameterizedTest
    @ValueSource(strings = {"+1 1234567890",
            "+44 9876543210",
            "+999 1111111111"})
    @DisplayName("Проверка валидных номеров")
    public void checkValidPhoneNumberTest(String phone) {
        assertTrue(isValidPhoneNumber(phone), "Номер невалиден");
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345",
            "invalid",
            "+1 abcdefghij",
            "+1234 1234567890",
            "+1 123",
            ""})
    @DisplayName("Проверка валидных номеров")
    public void checkInvalidPhoneNumberTest(String phone) {
        assertFalse(isValidPhoneNumber(phone), "Номер валиден");
    }

    @Test
    @DisplayName("Проверка на null")
    public void checkNullPhoneNumber() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> isValidPhoneNumber(null), "Должно быть выброшено исключение NullPointerException");
    }
}