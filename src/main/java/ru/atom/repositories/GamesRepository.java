package ru.atom.repositories;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import ru.atom.models.GameSession;

@Repository
public class GamesRepository
{
    private ConcurrentHashMap<Integer, GameSession> games = new ConcurrentHashMap<Integer, GameSession>();

    public ConcurrentHashMap<Integer, GameSession> getGames() {
        return games;
    }

    public void add(int id) {
        games.put(id, new GameSession(id, 0));
    }

    public GameSession get(Integer id)
    {
        if (games.containsKey(id)) {
            return games.get(id);
        }
        return null;
    }
}
