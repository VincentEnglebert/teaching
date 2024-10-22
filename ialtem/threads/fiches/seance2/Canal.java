package com.namur.sisters;

import java.util.LinkedList;
import java.util.Queue;

public class Canal {

    private final Queue<Message> queue = new LinkedList<>();
    private final int capacity;
    private final String code;

    public Canal(String code) {
        this.code = code;
        this.capacity = 10;
    }

    public String getCode() {
        return code;
    }


    public synchronized void produce(Message message) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.offer(message);
        notifyAll();
    }

    public synchronized Message consume() throws InterruptedException {

        while (queue.isEmpty()) {
            wait();
        }
        Message message = queue.poll();
        notifyAll();
        return message;
    }
}
