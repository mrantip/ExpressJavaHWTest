package org.example.patterns.facade.smarthouse;

public class Security implements SmartActivity {
    @Override
    public void turnOn() {
        System.out.println("Включить систему безопасности");
    }

    @Override
    public void turnOff() {
        System.out.println("Выключить систему безопасности");
    }
}