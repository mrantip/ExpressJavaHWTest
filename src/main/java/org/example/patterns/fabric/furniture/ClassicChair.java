package org.example.patterns.fabric.furniture;

public class ClassicChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Сидеть на классическом стуле");
    }
}