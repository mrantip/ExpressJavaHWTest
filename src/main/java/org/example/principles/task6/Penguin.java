package org.example.principles.task6;

public class Penguin extends Bird {
    public void fly() {
        throw new UnsupportedOperationException("Пингвины не летают");
    }
}