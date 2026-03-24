package org.example.patterns.builder.character;

public class Character {
    private String name;
    private int health;
    private int attack;
    private int armor;
    private int magic;

    private Character(CharacterBuilder characterBuilder) {
        this.name = characterBuilder.name;
        this.health = characterBuilder.health;
        this.attack = characterBuilder.attack;
        this.armor = characterBuilder.armor;
        this.magic = characterBuilder.magic;
    }

    static class CharacterBuilder {
        private String name;
        private int health;
        private int attack;
        private int armor;
        private int magic;

        public CharacterBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CharacterBuilder setHealth(int health) {
            this.health = health;
            return this;
        }

        public CharacterBuilder setAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public CharacterBuilder setArmor(int armor) {
            this.armor = armor;
            return this;
        }

        public CharacterBuilder setMagic(int magic) {
            this.magic = magic;
            return this;
        }

        public Character build() {
            return new Character(this);
        }
    }
}