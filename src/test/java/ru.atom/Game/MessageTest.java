package ru.atom.Game;

import org.assertj.core.error.ShouldBeAfterYear;
import org.junit.Test;
import ru.atom.models.DataTypes.DataDirection;
import ru.atom.models.Message;
import ru.atom.models.Player;
import ru.atom.models.GameSession;
import ru.atom.utils.JsonHelper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.atom.utils.JsonHelper.fromJson;
import static ru.atom.utils.JsonHelper.toJson;

public class MessageTest {
    @Test
    public void testBombMessageFromJson()
    {
        Message myMessage = new Message("BOMB", "");
        String JsonString = toJson(myMessage);

        Message result = fromJson(JsonString, Message.class);
        assertEquals(result, myMessage);
    }

    @Test
    public void testMoveMessageFromJson()
    {
        Message myMessage = new Message("MOVE", "UP");
        String JsonString = toJson(myMessage);

        Message result = fromJson(JsonString, Message.class);
        assertEquals(myMessage, result);
    }
}