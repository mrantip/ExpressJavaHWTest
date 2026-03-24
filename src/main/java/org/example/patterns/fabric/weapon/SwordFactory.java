package org.example.patterns.fabric.weapon;

public class SwordFactory extends WeaponFactory {
    @Override
    public Weapon createWeapon() {
        return new Sword();
    }
}