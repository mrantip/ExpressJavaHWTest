package codetesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountVowelsTest {

    public int countVowels(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return (int) input.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
    }

    @ParameterizedTest
    @CsvSource({"'hello', 2",
            "'java', 2",
            "'IOULIA', 5",
            "'', 0",
            "'aaa', 3",
            "'rtGTr', 0"})
    @DisplayName("Проверка строк с различным кол-вом букв, в т.ч. без гласных и без букв")
    public void checkPositiveCountVowels(String input, int expected) {
        assertEquals(expected, countVowels(input), "Количество глассных рассчитано некорректно");
    }

    @Test
    @DisplayName("Вместо строки передано null")
    public void checkNullString() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> countVowels(null), "Исключение не выброшено");
    }
}