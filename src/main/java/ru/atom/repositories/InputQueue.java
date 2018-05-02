package ru.atom.repositories;

import org.springframework.stereotype.Repository;
import ru.atom.models.Message;

import java.util.concurrent.ConcurrentLinkedQueue;

import static ru.atom.utils.JsonHelper.fromJson;

public class InputQueue {
    private ConcurrentLinkedQueue<Message> messages = new ConcurrentLinkedQueue<Message>();

    public ConcurrentLinkedQueue<Message> getMessages() {
        return messages;
    }

    public void push(String message) {
        messages.add(fromJson(message, Message.class));
    }

    public Message pop() {
        messages.poll();
        return null;
    }
}
