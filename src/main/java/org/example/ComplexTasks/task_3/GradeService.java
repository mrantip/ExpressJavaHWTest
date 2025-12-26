package org.example.ComplexTasks.task_3;

import java.util.ArrayList;
import java.util.List;

public class GradeService<T extends Number> {
    private List<StudentGrade<T>> grades = new ArrayList<>();

    public synchronized void addGrade(StudentGrade<T> grade) {
        if (grade.getGrade().doubleValue() < 0) {
            throw new InvalidGradeException("Оценка не может быть отрицательной");
        }
        grades.add(grade);
    }

    public synchronized double getAverageBySubject(String subject) {
        return grades.stream()
                .filter(grade -> grade.getSubject().equalsIgnoreCase(subject))
                .mapToDouble(grade -> grade.getGrade().doubleValue())
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Нет оценок по предмету: " + subject));
    }

    public List<StudentGrade<T>> getAllGrades() {
        return List.copyOf(grades);
    }
}