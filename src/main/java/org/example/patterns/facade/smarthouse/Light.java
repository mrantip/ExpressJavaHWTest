package org.example.patterns.facade.smarthouse;

public class Light implements SmartActivity {
    @Override
    public void turnOn() {
        System.out.println("Включить свет");
    }

    @Override
    public void turnOff() {
        System.out.println("Выключить свет");
    }
}