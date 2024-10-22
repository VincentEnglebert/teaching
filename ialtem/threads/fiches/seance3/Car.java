package com.namur.towerbridge;

public class Car extends Thread {
    private final String code;
    private final Bridge bridge;

    private final FIFO queue;

    public Car(String code, Bridge bridge, FIFO queue) {
        this.code = code;
        this.bridge = bridge;

        this.queue = queue;
        System.out.println(this.code + " from direction " + this.queue.getDirection());
    }

    public String getCode() {
        // Car name
        return code;
    }

    @Override
    public void run() {

        try {
            // Car try to enter on the bridge
            if(queue.getDirection() == Direction.LEFT){
                Thread.sleep(1000); // Simulate cross time
            }else{
                Thread.sleep(1000); // Simulate cross time
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}