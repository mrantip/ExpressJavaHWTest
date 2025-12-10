package codetesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountWordsTest {

    public int countWords(String sentence) {
        String newsentence = sentence.replaceAll("\\p{Z}+", " ").trim();
        return newsentence.isEmpty() ? 0 : newsentence.split(" ").length;
    }

    @ParameterizedTest
    @CsvSource({"'Hello world', 2",
            "' Java is awesome ', 3",
            "'', 0",
            "' ', 0"})
    @DisplayName("Проверка строк с различным количеством слов и пробелов")
    public void checkCountWords(String sentence, int expected) {
        assertEquals(expected, countWords(sentence), "Количество слов рассчитано неверно");
    }

    @Test
    @DisplayName("Проверка на null")
    public void checkNullString() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> countWords(null), "Должно быть выброшено исключение NullPointerException");
    }
}