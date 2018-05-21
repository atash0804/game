package ru.atom.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import ru.atom.models.GameSession;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Repository
public class SessionRepository {
    private BlockingQueue<GameSession> sessions = new LinkedBlockingQueue<>();

    public void add(GameSession session)
    {
        sessions.add(session);
    }

    public void remove(GameSession session)
    {
        sessions.remove(session);
    }

    public GameSession get(long id)
    {
//        for (GameSession session : sessions)
//            if (session.getId() == id)
//                return session;
        return null;
    }

    public BlockingQueue<GameSession> getSessions() {
        return sessions;
    }
}
