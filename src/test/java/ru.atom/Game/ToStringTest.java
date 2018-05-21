package ru.atom.Game;

import org.junit.Test;
import ru.atom.GameObject.Bomb;
import ru.atom.GameObject.Pawn;
import ru.atom.GameObject.Tile;
import ru.atom.geometry.Point;
import ru.atom.GameObject.TileType;
import ru.atom.models.GameSession;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class ToStringTest {
    @Test
    public void testTileToString()
    {
        Pawn myPawn = new Pawn(2, new Point(1.1,2));
        System.out.println(myPawn.toString());
        Bomb myBomb = new Bomb(2, new Point(1.1,2), 0);
        System.out.println(myBomb.toString());
    }

    @Test
    public void testPushAndGetReplica() {
        GameSession s = new GameSession(5,2);
        s.pushMessage(1, "{\"topic\":\"PLANT_BOMB\",\"data\":{}}");
        s.pushMessage(1, "{\"topic\":\"MOVE\",\"data\":{\"direction\":\"UP\"}}");
        for (int i = 0; i < 10; i++) {
            System.out.println(s.getReplica());
            try{
                sleep(1000);
            } catch (Exception e) {

            }
        }
    }

    @Test
    public void testGetReplica() {
        GameSession s = new GameSession(5,2);
        System.out.println(s.getReplica());
    }
}
