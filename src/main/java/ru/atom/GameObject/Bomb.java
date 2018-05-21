package ru.atom.GameObject;

import org.json.JSONException;
import org.json.JSONObject;
import ru.atom.geometry.Point;
import ru.atom.tickables.Tickable;

import java.util.HashMap;
import java.util.Map;

public class Bomb extends GameObject implements Tickable {
    private int LIFETIME = 2000;
    private int elapsed = 0;
    private int owner;

    public Bomb(int id, Point position, int owner) {
        super(id, 28, 28, position);
        this.owner = owner;
    }

    public int getOwner() {
        return owner;
    }

    @Override
    public void tick(long elapsed) {
        this.elapsed += elapsed;
    }

    public boolean isAlive() {
        return elapsed < LIFETIME;
    }

    //{"position":{"x":16.0,"y":12.0},"id":16,"type":"Bomb"}
    @Override
    public String toString() {
        JSONObject position = new JSONObject();
        try {
            position.put("x", (double) getPosition().getX());
            position.put("y", (double) getPosition().getY());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject resultJson = new JSONObject();

        try {
            resultJson.put("position",position);
            resultJson.put("id", getId());
            resultJson.put("type", "Bomb");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return resultJson.toString();
    }
}
