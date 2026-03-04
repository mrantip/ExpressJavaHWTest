package org.example.patterns.facade.smarthouse;

public class Conditioner implements SmartActivity {
    @Override
    public void turnOn() {
        System.out.println("Включить кондиуионер");
    }

    @Override
    public void turnOff() {
        System.out.println("Выключить кондиуионер");
    }
}