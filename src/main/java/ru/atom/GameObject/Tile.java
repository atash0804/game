package ru.atom.GameObject;

import ru.atom.geometry.Point;

public class Tile extends GameObject {
    TileType type;

    public Tile(int id, TileType type, Point position) {
        super(id, 32, 32, position);
        this.type = type;
    }

    public TileType getType() {
        return type;
    }
}
