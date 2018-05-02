package ru.atom.GameObject;

public class Bonus extends GameObject {
    BonusType type;

    public Bonus(int id, BonusType type) {
        super(id, 30, 30);
        this.type = type;
    }

    public BonusType getType() {
        return type;
    }
}
