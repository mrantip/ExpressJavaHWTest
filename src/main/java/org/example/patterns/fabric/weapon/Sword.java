package org.example.patterns.fabric.weapon;

public class Sword implements Weapon {
    @Override
    public void attack() {
        System.out.println("Удар мечом");
    }
}