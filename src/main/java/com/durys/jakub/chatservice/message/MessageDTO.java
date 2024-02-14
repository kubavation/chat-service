package com.durys.jakub.chatservice.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class MessageDTO {
    private String text;
    private String from;
}
