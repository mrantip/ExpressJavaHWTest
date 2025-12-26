package ComplexTasksTests.task_1_tests;

import org.example.ComplexTasks.task_1.EntityManager;
import org.example.ComplexTasks.task_1.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerTest {

    @Test
    @DisplayName("Проверка добавления сущности")
    public void addEntityTest() {
        EntityManager<Student> manager = new EntityManager<>();
        Student student = new Student("Kolia", 15, true);
        int initialSize = manager.getAll().size();
        manager.add(student);
        Student actualStudent = manager.getAll().get(0);

        assertEquals(initialSize + 1, manager.getAll().size(), "Размер списка не соответствует ожидаемому");
        assertEquals(student.getName(), actualStudent.getName(), "Имя не соответствует");
        assertEquals(student.getAge(), actualStudent.getAge(), "Возраст не соответствует");
        assertEquals(student.isActive(), actualStudent.isActive(), "Статус активности не соответствует");
    }

    @Test
    @DisplayName("Проверка удаления сущности")
    public void removeEntityTest() {
        EntityManager<Student> manager = new EntityManager<>();
        Student student = new Student("Kolia", 15, true);
        manager.add(student);
        int actualSize = manager.getAll().size();

        assertTrue(manager.remove(student), "Ответ не соответсвует ожидаемому");
        assertFalse(manager.remove(student), "Ответ не соответсвует ожидаемому");
        assertEquals(actualSize - 1, manager.getAll().size(), "Размер списка не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка фильтра по имени")
    public void filterByNameTest() {
        EntityManager<Student> manager = new EntityManager<>();
        Student student1 = new Student("Kolia", 15, true);
        Student student2 = new Student("Pasha", 25, true);
        Student student3 = new Student("Masha", 35, true);
        manager.add(student1);
        manager.add(student2);
        manager.add(student3);
        List<Student> result = manager.filterByName("Pasha");
        List<Student> resultEmpty = manager.filterByName("FFFF");

        assertEquals(1, result.size(), "Размер списка не соответствует ожидаемому");
        assertEquals(0, resultEmpty.size(), "Размер списка не соответствует ожидаемому");
        assertEquals("Pasha", result.get(0).getName(), "Имя не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка фильтра по возрасту")
    public void filterByAgeTest() {
        EntityManager<Student> manager = new EntityManager<>();
        Student student1 = new Student("Kolia", 15, true);
        Student student2 = new Student("Pasha", 25, true);
        Student student3 = new Student("Masha", 35, true);
        manager.add(student1);
        manager.add(student2);
        manager.add(student3);
        List<Student> result = manager.filterByAge(20, 30);
        List<Student> resultEmpty = manager.filterByAge(36, 100);

        assertEquals(1, result.size(), "Размер списка не соответствует ожидаемому");
        assertEquals(0, resultEmpty.size(), "Размер списка не соответствует ожидаемому");
        assertEquals(25, result.get(0).getAge(), "Возраст не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка фильтра по статусу активности")
    public void filterByActivityTest() {
        EntityManager<Student> manager = new EntityManager<>();
        Student student1 = new Student("Kolia", 15, true);
        Student student2 = new Student("Pasha", 25, false);
        manager.add(student1);
        manager.add(student2);
        List<Student> result = manager.filterByActivity(true);
        assertEquals(1, result.size(), "Размер списка не соответствует ожидаемому");
        assertEquals("Kolia", result.get(0).getName(), "Имя не соответствует ожидаемому");
    }
}