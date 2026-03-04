package org.example.patterns.fabric.furniture;

public class ClassicTable implements Table {
    @Override
    public void use() {
        System.out.println("Пользоваться классическим столом");
    }
}