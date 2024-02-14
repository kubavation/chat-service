package com.durys.jakub.chatservice.shared;

import org.springframework.stereotype.Component;

@Component
class DefaultIdentifierGenerator implements IdentifierGenerator {

    private Long value = 0L;

    @Override
    public Long next() {
        value += 1;
        return value;
    }
}
