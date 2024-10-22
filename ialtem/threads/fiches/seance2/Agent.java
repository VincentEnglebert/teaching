package com.namur.sisters;

class Agent extends Thread {
    protected final Canal inCanal;
    protected final Canal outCanal;
    protected final String identity;
    protected int consumeTime = 10;

    public Agent(String identity, Canal inCanal, Canal outCanal) {
        this.identity = identity;
        this.inCanal = inCanal;
        this.outCanal = outCanal;
    }

    public String getIdentity() {
        return identity;
    }


    public void setConsumeTime(int consumeTime) {
        this.consumeTime = consumeTime;
    }
}