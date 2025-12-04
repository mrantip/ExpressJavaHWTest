package codetesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReverseStringTest {

    public String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    @ParameterizedTest
    @CsvSource({"'olleh', 'hello'",
            "'avaJ', 'Java'",
            "'', ''",
            "'a', 'a'",
            "'12345', '54321'"})
    @DisplayName("Проверка разворота различных строк")
    public void checkReversedString(String expected, String input) {
        assertEquals(expected, reverse(input), "Строка не перевернута корректно");
    }

    @Test
    @DisplayName("Проверка на null")
    public void checkNullString() {
        assertNull(reverse(null), "Возвращено не null");
    }
}