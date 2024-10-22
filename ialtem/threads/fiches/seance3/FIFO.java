package com.namur.towerbridge;

import java.util.LinkedList;
import java.util.Queue;

public class FIFO {

    private final Queue<Car> queue = new LinkedList<>();

    private final Direction direction;

    public FIFO(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        // Car direction
        return direction;
    }
}