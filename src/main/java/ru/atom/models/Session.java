package ru.atom.models;

import ru.atom.GameObject.GameObject;
import ru.atom.GameObject.Pawn;
import ru.atom.GameObject.Tile;
import ru.atom.geometry.Point;
import ru.atom.repositories.InputQueue;
import ru.atom.tickables.Tickable;

import java.util.ArrayList;
import java.util.List;

import static ru.atom.GameObject.TileType.CRATE;
import static ru.atom.GameObject.TileType.WALL;

public class Session implements Runnable {
    private int id;
    private int playerCount;
    private List<Player> players = new ArrayList<>();
    private InputQueue messages = new InputQueue();
    private List<GameObject> objects = new ArrayList<GameObject>();
    private int objId;

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    private boolean isFinished = false;

    public int getPlayerCount() {
        return playerCount;
    }

    public Session(int id, int playerCount) {
        this.id = id;
        this.playerCount = playerCount;
        initObjects(playerCount);
    }

    private int getObjId() {
        objId++;
        return objId;
    }

    public InputQueue getMessages() {
        return messages;
    }

    /*Game field contains 27x17 tiles
            At start of the game all tiles except corner ones and
            edges are CRATEs, edges are WALLs and corners are empty
         */
    private void initObjects(int playerCount) {
        for (int i = 0; i < 27; i++) {
            objects.add(new Tile(getObjId(), WALL, new Point(i, 0)));
            objects.add(new Tile(getObjId(), WALL, new Point(i, 16)));
        }
        for (int i = 1; i < 16; i++) {
            objects.add(new Tile(getObjId(), WALL, new Point(0, i)));
            objects.add(new Tile(getObjId(), WALL, new Point(26, i)));
        }
        for (int i = 1; i < 26; i++) {
            for (int j = 1; j < 16; j++) {
                if (((i == 1) && ((j == 1) || (j == 15))) || ((i == 25) && ((j == 1) || (j == 15)))) {
                    continue;
                }
                objects.add(new Tile(getObjId(), CRATE, new Point(i, j)));
            }
        }
        switch (playerCount) {
            case 4: objects.add(new Pawn(getObjId(), new Point(1, 15)));
            case 3: objects.add(new Pawn(getObjId(), new Point(25, 1)));
            case 2: objects.add(new Pawn(getObjId(), new Point(25, 15)));
            case 1: objects.add(new Pawn(getObjId(), new Point(1, 1)));
        }
    }

    public GameObject getGameObjectByPosition(Point position) {
        for (GameObject object : objects) {
            if (object.getPosition().equals(position))  {
                return object;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFull() {
        return players.size() >= playerCount;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public double getAverageRating() {
        double rating = 0;
        for (Player player : players)
            rating += player.getRating();
        return rating / players.size();
    }

    @Override
    public void run() {

    }
}
