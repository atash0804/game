package ru.atom.GameObject;

import ru.atom.tickables.Tickable;

public class Bomb extends GameObject implements Tickable {
    private int LIFETIME = 2000;
    private int elapsed = 0;

    public Bomb(int id) {
        super(id, 28, 28);
    }

    @Override
    public void tick(long elapsed) {
        this.elapsed += elapsed;
    }

    public boolean isAlive() {
        return elapsed < LIFETIME;
    }
}
