package ru.atom.GameObject;

public class Tile extends GameObject {
    TileType type;

    public Tile(int id, TileType type) {
        super(id, 32, 32);
        this.type = type;
    }

    public TileType getType() {
        return type;
    }
}
