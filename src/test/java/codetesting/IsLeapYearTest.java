package codetesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsLeapYearTest {

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {2020, 2000, 1600, 0, 4, 400})
    @DisplayName("Проверка действительно высокосных годов")
    public void checkLeapYearTrue(int year) {
        assertTrue(isLeapYear(year), "Год не является высокосным");
    }

    @ParameterizedTest
    @ValueSource(ints = {2019, 2021, 2022, 1900, 2100})
    @DisplayName("Проверка не высокосных годов")
    public void checkLeapYearFalse(int year) {
        assertFalse(isLeapYear(year), "Год является высокосным");
    }
}