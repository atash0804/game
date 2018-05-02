package ru.atom.GameObject;

import ru.atom.tickables.Tickable;

public class Fire extends GameObject implements Tickable {
    private int LIFETIME = 200;
    private int elapsed = 0;

    public Fire(int id) {
        super(id, 38, 38);
    }

    @Override
    public void tick(long elapsed) {
        this.elapsed += elapsed;
    }

    public boolean isAlive() {
        return elapsed < LIFETIME;
    }
}
