package org.example.principles.task7;

public class Programmer implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Программист пишет код");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Программист не ест на работе");
    }
}