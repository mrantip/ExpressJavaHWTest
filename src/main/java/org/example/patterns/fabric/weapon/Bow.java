package org.example.patterns.fabric.weapon;

public class Bow implements Weapon {
    @Override
    public void attack() {
        System.out.println("Выстрел из лука");
    }
}