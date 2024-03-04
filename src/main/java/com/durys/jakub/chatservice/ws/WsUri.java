package com.durys.jakub.chatservice.ws;

public enum WsUri {
    CHAT("/topic/messages/%d");

    private final String uri;

    WsUri(String uri) {
        this.uri = uri;
    }

    public String uri() {
        return uri;
    }
}
