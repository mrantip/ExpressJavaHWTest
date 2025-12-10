package codetesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    public int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    @ParameterizedTest
    @CsvSource({"1, 0",
            "1, 1",
            "120, 5",
            "5040, 7"})
    @DisplayName("Проверка расчета факториала чисел >= 0")
    public void checkLegalFactorial(int expected, int number) {
        assertEquals(expected, factorial(number), "Факториал рассчитан некорректно");
    }

    @Test
    @DisplayName("Проверка расчета факториала чисел < 0")
    public void checkNegativeNumberFactorial() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> factorial(-3), "Исключение не выброшено");
    }
}