package org.example.patterns.fabric.weapon;

public class GunFactory extends WeaponFactory {
    @Override
    public Weapon createWeapon() {
        return new Gun();
    }
}