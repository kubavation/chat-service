package com.durys.jakub.chatservice.ws;

public enum WsURI {
    CHAT("/topic/messages/%d"),
    PRESENCE("/topic/presence/%d");

    private final String uri;

    WsURI(String uri) {
        this.uri = uri;
    }

    public String uri() {
        return uri;
    }
}
