package org.example.patterns.fabric.weapon;

public class Gun implements Weapon {
    @Override
    public void attack() {
        System.out.println("Выстрел из пистолета");
    }
}