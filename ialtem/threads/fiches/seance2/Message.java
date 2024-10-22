package com.namur.sisters;

public class Message {
    private final String content;
    private final String from;
    Message(String content, String from){
        this.content = content;
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public String getFrom() {
        return from;
    }
}
