package codetesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindMaxTest {

    public int findMax(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }

    @Test
    @DisplayName("Проверка массива с положительными числами")
    public void checkPositiveNumbersArray() {
        int[] nums = {3, 5, 7, 2};
        assertEquals(7, findMax(nums), "Максимальное число найдено неверно");
    }

    @Test
    @DisplayName("Проверка массива с 1 числом")
    public void checkOneElementArray() {
        int[] nums = {1};
        assertEquals(1, findMax(nums), "Максимальное число найдено неверно");
    }

    @Test
    @DisplayName("Проверка массива с отрицательными числами")
    public void checkNegativeNumbersArray() {
        int[] nums = {-3, -5, -7, -2};
        assertEquals(-2, findMax(nums), "Максимальное число найдено неверно");
    }

    @Test
    @DisplayName("Проверка пустого массива")
    public void checkEmptyArray() {
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> findMax(new int[]{}), "Неверное исключение");
    }

    @Test
    @DisplayName("Проверка null")
    public void checkNull() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> findMax(null), "Неверное исключение");
    }
}