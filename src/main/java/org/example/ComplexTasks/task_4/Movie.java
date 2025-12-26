package org.example.ComplexTasks.task_4;

import java.util.Objects;

public class Movie {
    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Movie && Objects.equals(title, ((Movie) o).title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}