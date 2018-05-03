package ru.atom.GameObject;

import ru.atom.geometry.Point;

public class Bonus extends GameObject {
    BonusType type;

    public Bonus(int id, BonusType type, Point position) {
        super(id, 30, 30, position);
        this.type = type;
    }

    public BonusType getType() {
        return type;
    }
}
