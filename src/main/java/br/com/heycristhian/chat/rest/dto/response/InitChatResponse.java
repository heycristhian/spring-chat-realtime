package br.com.heycristhian.chat.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InitChatResponse(
        @JsonProperty("chatId")
        Long id
) {
}
