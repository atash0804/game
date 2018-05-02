package ru.atom.repositories;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import ru.atom.models.Session;

@Repository
public class GamesRepository
{
    private ConcurrentHashMap<Integer, Session> games = new ConcurrentHashMap<Integer, Session>();

    public ConcurrentHashMap<Integer, Session> getGames() {
        return games;
    }

    public void add(int id) {
        games.put(id, new Session(id, 0));
    }

    public Session get(Integer id)
    {
        if (games.containsKey(id)) {
            return games.get(id);
        }
        return null;
    }
}
