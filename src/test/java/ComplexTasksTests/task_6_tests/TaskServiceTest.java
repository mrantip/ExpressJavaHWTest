package ComplexTasksTests.task_6_tests;

import org.example.ComplexTasks.task_6.Task;
import org.example.ComplexTasks.task_6.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    @DisplayName("Проверка добавления задания")
    public void addTaskTest() {
        TaskService<String> service = new TaskService<>();
        Task<String> task = new Task<>("1", Task.Status.NEW, Task.Priority.MEDIUM, LocalDateTime.now());
        service.addTask(task);
        assertEquals(1, service.getAllTasks().size());
    }

    @Test
    @DisplayName("Проверка добавления дубликата задания")
    public void addDuplicateTaskTest() {
        TaskService<String> service = new TaskService<>();
        Task<String> task = new Task<>("1", Task.Status.NEW, Task.Priority.MEDIUM, LocalDateTime.now());
        service.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task));
    }

    @Test
    @DisplayName("Проверка удаления задания")
    public void removeTaskTest() {
        TaskService<String> service = new TaskService<>();
        Task<String> task = new Task<>("1", Task.Status.NEW, Task.Priority.MEDIUM, LocalDateTime.now());
        service.addTask(task);
        assertTrue(service.removeTaskById("1"));
        assertFalse(service.removeTaskById("1"));
    }

    @Test
    @DisplayName("Проверка фильтра по статусу")
    public void filterByStatusTest() {
        TaskService<String> service = new TaskService<>();
        Task<String> task1 = new Task<>("1", Task.Status.NEW, Task.Priority.MEDIUM, LocalDateTime.now());
        Task<String> task2 = new Task<>("2", Task.Status.IN_PROGRESS, Task.Priority.MEDIUM, LocalDateTime.now());
        service.addTask(task1);
        service.addTask(task2);
        List<Task<String>> result = service.getTasksByStatus(Task.Status.IN_PROGRESS);
        assertEquals(1, result.size());
        assertEquals("2", result.get(0).getId());
    }

    @Test
    @DisplayName("Проверка фильтра по приоритету")
    public void filterByPriorityTest() {
        TaskService<String> service = new TaskService<>();
        Task<String> task1 = new Task<>("1", Task.Status.NEW, Task.Priority.MEDIUM, LocalDateTime.now());
        Task<String> task2 = new Task<>("2", Task.Status.IN_PROGRESS, Task.Priority.HIGH, LocalDateTime.now());
        service.addTask(task1);
        service.addTask(task2);
        List<Task<String>> result = service.getTasksByPriority(Task.Priority.HIGH);
        assertEquals(1, result.size());
        assertEquals("2", result.get(0).getId());
    }

    @Test
    @DisplayName("Проверка сортировки по дате")
    public void sortByDateTest() {
        TaskService<String> service = new TaskService<>();
        Task<String> task1 = new Task<>("1", Task.Status.NEW, Task.Priority.MEDIUM, LocalDateTime.of(2025, 1, 1, 1, 1));
        Task<String> task2 = new Task<>("2", Task.Status.IN_PROGRESS, Task.Priority.HIGH, LocalDateTime.of(2024, 1, 1, 1, 1));
        service.addTask(task1);
        service.addTask(task2);
        List<Task<String>> sorted = service.getTasksSortedByDate();
        assertEquals("2", sorted.get(0).getId());
    }
}