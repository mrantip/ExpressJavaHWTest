package org.example.principles.task6;

public class FlyingBird extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Птица летит");
    }
}