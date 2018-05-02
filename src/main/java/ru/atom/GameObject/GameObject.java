package ru.atom.GameObject;

public abstract class GameObject {
    private int id = 0;
    private int height = 0;
    private int width = 0;

    public int getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public GameObject(int id, int height, int width) {
        this.id = id;
        this.height = height;
        this.width = width;
    }
}
