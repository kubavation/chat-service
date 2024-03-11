package com.durys.jakub.chatservice.ws;

public enum WsURI {
    CHAT("/topic/messages/%d", "/topic/messages"),
    PRESENCE("/topic/presence/%d", "/topic/presence");

    private final String uri;
    private final String endpoint;

    WsURI(String uri, String endpoint) {
        this.uri = uri;
        this.endpoint = endpoint;
    }

    public String uri() {
        return uri;
    }

    public String endpoint() {
        return endpoint;
    }
}
