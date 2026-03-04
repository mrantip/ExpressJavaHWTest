package org.example.patterns.facade.smarthouse;

public class SmartHouseFacade {
    private Light light;
    private Conditioner conditioner;
    private Security security;

    public SmartHouseFacade() {
        this.light = new Light();
        this.conditioner = new Conditioner();
        this.security = new Security();
    }

    public void turnOn(String device) {
        if (device.equalsIgnoreCase("свет")) {
            light.turnOn();
        } else if (device.equalsIgnoreCase("кондиционер")) {
            conditioner.turnOn();
        } else if (device.equalsIgnoreCase("безопасность")) {
            security.turnOn();
        } else {
            System.out.println("Неверная команда");
        }
    }

    public void turnOff(String device) {
        if (device.equalsIgnoreCase("свет")) {
            light.turnOff();
        } else if (device.equalsIgnoreCase("кондиционер")) {
            conditioner.turnOff();
        } else if (device.equalsIgnoreCase("безопасность")) {
            security.turnOff();
        } else {
            System.out.println("Неверная команда");
        }
    }
}