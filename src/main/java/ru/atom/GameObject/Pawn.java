package ru.atom.GameObject;

import ru.atom.geometry.Point;
import ru.atom.tickables.Tickable;

import static ru.atom.GameObject.PawnState.IDLE;

public class Pawn extends GameObject implements Tickable {
    private double BASIC_SPEED = 1.0;
    private double SPEED_PERK = 0.5;
    private int speedBonus = 0;
    private int bombBonus = 0;
    private int forceBonus = 0;
    private PawnState state = IDLE;
    private Point pix_position;

    public Pawn(int id, Point position) {
        super(id, 26, 26, position);
        this.pix_position = new Point(position.getX() * 32, position.getY()*32);
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

    public int getForceBonus() {
        return forceBonus;
    }

    public void setState(PawnState state) {
        this.state = state;
    }

    @Override
    public void tick(long elapsed) {
        
    }
}
