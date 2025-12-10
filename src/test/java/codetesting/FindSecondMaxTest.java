package codetesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindSecondMaxTest {

    public int findSecondMax(int[] numbers) {
        return Arrays.stream(numbers).distinct().sorted().skip(numbers.length - 2).findFirst().orElseThrow();
    }

    @Test
    @DisplayName("Проверка массива с различными числами")
    public void checkArrayWithDifferentNumbers() {
        int[] array = {3, 5, 7, 2, -2};
        assertEquals(5, findSecondMax(array), "Найдено некорректное число");
    }

    @Test
    @DisplayName("Проверка массива с одинаковыми числами")
    public void checkArrayWithSameNumbers() {
        int[] array = {4, 4, 4, 4, 4};
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> findSecondMax(array), "Должно быть выброшено исключение NoSuchElementException");
    }

    @Test
    @DisplayName("Проверка массива с 1 числом")
    public void checkArrayWithOneNumber() {
        int[] array = {4};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> findSecondMax(array), "Должно быть выброшено исключение IllegalArgumentException");
    }

    @Test
    @DisplayName("Проверка пустого массива")
    public void checkEmptyArray() {
        int[] array = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> findSecondMax(array), "Должно быть выброшено исключение IllegalArgumentException");
    }
}