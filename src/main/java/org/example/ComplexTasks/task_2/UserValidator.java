package org.example.ComplexTasks.task_2;

import java.util.regex.Pattern;

public class UserValidator {
    public static boolean validationEnabled = true;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");

    public void validate(User user) {
        if (!validationEnabled || user == null) return;
        validateName(user.getName());
        validateAge(user.getAge());
        validateEmail(user.getEmail());
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) throw new InvalidUserException("Имя не может быть пустым");
        if (!Character.isUpperCase(name.charAt(0)))
            throw new InvalidUserException("Имя должно начинаться с заглавной буквы");
    }

    private void validateAge(int age) {
        if (age < 18 || age > 100) throw new InvalidUserException("Возраст должен быть в диапазоне от 18 до 100 лет");
    }

    private void validateEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches())
            throw new InvalidUserException("Невалидный email");
    }
}