package ComplexTasksTests.task_3_tests;

import org.example.ComplexTasks.task_3.GradeService;
import org.example.ComplexTasks.task_3.InvalidGradeException;
import org.example.ComplexTasks.task_3.StudentGrade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GradeServiceTest {

    @Test
    @DisplayName("Проверка добавления валидной оценки")
    public void addValidGradeTest() {
        GradeService<Integer> service = new GradeService<>();
        StudentGrade<Integer> grade = new StudentGrade<>("Sasha", "Philosophy", 70);
        int initialSize = service.getAllGrades().size();
        service.addGrade(grade);
        assertEquals(initialSize + 1, service.getAllGrades().size());
    }

    @Test
    @DisplayName("Проверка добавления невалидной оценки")
    public void addInvalidGradeTest() {
        GradeService<Integer> service = new GradeService<>();
        StudentGrade<Integer> grade = new StudentGrade<>("Sasha", "Philosophy", -70);
        assertThrows(InvalidGradeException.class, () -> service.addGrade(grade));
    }

    @Test
    @DisplayName("Проверка расчета средней оценки")
    public void averageGradeTest() {
        GradeService<Integer> service = new GradeService<>();
        StudentGrade<Integer> grade = new StudentGrade<>("Sasha", "Philosophy", 70);
        StudentGrade<Integer> grade2 = new StudentGrade<>("Dasha", "Philosophy", 80);
        service.addGrade(grade);
        service.addGrade(grade2);
        assertEquals(75.0, service.getAverageBySubject("Philosophy"));
    }

    @Test
    @DisplayName("Проверка расчета средней оценки по отсутствуещему предмету")
    public void averageNoSubjectTest() {
        GradeService<Integer> service = new GradeService<>();
        StudentGrade<Integer> grade = new StudentGrade<>("Sasha", "Philosophy", 70);
        StudentGrade<Integer> grade2 = new StudentGrade<>("Dasha", "Music", 80);
        service.addGrade(grade);
        service.addGrade(grade2);
        assertThrows(IllegalArgumentException.class, () -> service.getAverageBySubject("Math"));
    }
}