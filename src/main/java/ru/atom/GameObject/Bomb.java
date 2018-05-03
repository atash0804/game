package ru.atom.GameObject;

import ru.atom.geometry.Point;
import ru.atom.tickables.Tickable;

public class Bomb extends GameObject implements Tickable {
    private int LIFETIME = 2000;
    private int elapsed = 0;
    private int force;
    private Pawn owner;

    public Bomb(int id, Point position, Pawn owner) {
        super(id, 28, 28, position);
        this.owner = owner;
        this.force = owner.getForceBonus();
    }

    public Pawn getOwner() {
        return owner;
    }

    @Override
    public void tick(long elapsed) {
        this.elapsed += elapsed;
    }

    public boolean isAlive() {
        return elapsed < LIFETIME;
    }
}
