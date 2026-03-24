package org.example.patterns.builder.character;

public class Game {
    private String name;
    private Character.CharacterBuilder characterBuilder;

    public Game(String name) {
        this.name = name;
        this.characterBuilder = new Character.CharacterBuilder();
    }

    public Character createCharacter(String name, int health, int attack, int armor, int magic) {
        return characterBuilder.setName(name).setHealth(health).setAttack(attack)
                .setArmor(armor).setMagic(magic).build();
    }
}