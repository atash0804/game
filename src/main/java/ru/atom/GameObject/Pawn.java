package ru.atom.GameObject;

import ru.atom.tickables.Tickable;

public class Pawn extends GameObject implements Tickable {
    int speedBonus = 0;
    int bombBonus = 0;
    int forceBonus = 0;

    public Pawn(int id) {
        super(id, 26, 26);
    }

    public void incSpeed() {
        speedBonus++;
    }

    public void incBomb() {
        bombBonus++;
    }

    public void incForce() {
        forceBonus++;
    }

    @Override
    public void tick(long elapsed) {

    }
}
