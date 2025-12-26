package ComplexTasksTests.task_4_tests;

import org.example.ComplexTasks.task_4.Movie;
import org.example.ComplexTasks.task_4.MovieService;
import org.example.ComplexTasks.task_4.Rating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovieServiceTest {

    @Test
    @DisplayName("Проверка добавления рейтинга и рсчета средней оценки")
    public void addAndAverageRatingTest() {
        MovieService<Integer> service = new MovieService<>();
        Movie movie = new Movie("movie");
        service.addRating(movie, new Rating<>(5));
        service.addRating(movie, new Rating<>(6));
        assertEquals(5.5, service.getAverageRating(movie));
    }

    @Test
    @DisplayName("Проверка получения рейтинга без рейтинга")
    public void averageWithoutRatingTest() {
        MovieService<Integer> service = new MovieService<>();
        Movie movie = new Movie("movie");
        assertThrows(IllegalArgumentException.class, () -> service.getAverageRating(movie));
    }

    @Test
    @DisplayName("Проверка добавления невалидной оценки")
    public void addInvalidRatingTest() {
        MovieService<Integer> service = new MovieService<>();
        Movie movie = new Movie("movie");
        assertThrows(IllegalArgumentException.class, () -> service.addRating(movie, new Rating<>(11)));
    }

    @Test
    @DisplayName("Проверка сортировки по рейтингу")
    public void sortedMoviesByRatingTest() {
        MovieService<Integer> service = new MovieService<>();
        Movie movie1 = new Movie("movie 1");
        Movie movie2 = new Movie("movie 2");
        service.addRating(movie1, new Rating<>(6));
        service.addRating(movie2, new Rating<>(7));
        List<Movie> sorted = service.getSortedMovieByRating();
        assertEquals(movie2, sorted.get(0));
        assertEquals(movie1, sorted.get(1));
    }
}