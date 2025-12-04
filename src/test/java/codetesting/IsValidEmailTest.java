package codetesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class IsValidEmailTest {

    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@example.com", "user.name@domain.co", "a@b.cc"})
    @DisplayName("Проверка валидных emails")
    public void checkValidEmail(String email) {
        assertTrue(isValidEmail(email), "Невалидный email");
    }

    @ParameterizedTest
    @ValueSource(strings = {"bad@.com", "no-at-symbol", "@missing-user.com", "user@domain", ""})
    @DisplayName("Проверка невалидных emails")
    public void checkInvalidEmail(String email) {
        assertFalse(isValidEmail(email), "Валидный email");
    }

    @Test
    @DisplayName("Проверка на null")
    public void checkNullEmail() {
        assertFalse(isValidEmail(null), "Валидный email");
    }
}