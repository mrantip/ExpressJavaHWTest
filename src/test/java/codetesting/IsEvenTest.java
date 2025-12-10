package codetesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsEvenTest {

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 0, -4})
    @DisplayName("Проверка четных позитивных, негативных чисел и нуля")
    public void checkEvenNumbers(int num) {
        assertTrue(isEven(num), "Число не четное");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -5, -11})
    @DisplayName("Проверка нечетныхисел")
    public void checkIsNotEvenNumbers(int num) {
        assertFalse(isEven(num), "Число нчетное");
    }
}