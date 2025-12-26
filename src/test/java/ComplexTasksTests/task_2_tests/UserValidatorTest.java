package ComplexTasksTests.task_2_tests;

import org.example.ComplexTasks.task_2.InvalidUserException;
import org.example.ComplexTasks.task_2.User;
import org.example.ComplexTasks.task_2.UserValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorTest {
    private UserValidator validator = new UserValidator();

    @Test
    @DisplayName("Проверка валидного юзера")
    public void validUserTest() {
        User user = new User("Sasha", 18, "sasha@mail.ru");
        assertDoesNotThrow(() -> validator.validate(user));
    }

    @Test
    @DisplayName("Проверка пустого имени юзера")
    public void emptyUserTest() {
        User user = new User("", 18, "sasha@mail.ru");
        assertThrows(InvalidUserException.class, () -> validator.validate(user));
    }

    @Test
    @DisplayName("Проверка имени юзера начинающегося с маленькой буквы")
    public void nameLowerCaseTest() {
        User user = new User("sasha", 18, "sasha@mail.ru");
        assertThrows(InvalidUserException.class, () -> validator.validate(user));
    }

    @ParameterizedTest
    @DisplayName("Проверка некорректного возраста юзера")
    @CsvSource({
            "Tom, 17, sasha@gmail.com",
            "Alice, 5, sasha@mail.ru",
            "Bob, 101, sas@mail.ru",
            "John, 4000, sha@mail.ru"
    })
    public void invalidAgeTest(String name, int age, String email) {
        User user = new User(name, age, email);
        assertThrows(InvalidUserException.class, () -> validator.validate(user));
    }

    @ParameterizedTest
    @DisplayName("Проверка некорректного email юзера")
    @CsvSource({
            "Tom, 18, sasha",
            "Alice, 25, sasha@.ru",
            "Bob, 100, mail.ru",
            "John, 40, ''"
    })
    public void invalidEmailTest(String name, int age, String email) {
        User user = new User(name, age, email);
        assertThrows(InvalidUserException.class, () -> validator.validate(user));
    }

    @Test
    @DisplayName("Проверка невалидного юзера с отключенным валидатором")
    public void validationDisabledTest() {
        UserValidator.validationEnabled = false;
        User user = new User("sasha", 1000, "sasha");
        assertDoesNotThrow(() -> validator.validate(user));
    }
}