package br.com.heycristhian.chat.rest.controller;

import br.com.heycristhian.chat.mapper.ChatMapper;
import br.com.heycristhian.chat.rest.dto.InitChatRequest;
import br.com.heycristhian.chat.rest.dto.response.ChatResponse;
import br.com.heycristhian.chat.rest.dto.response.InitChatResponse;
import br.com.heycristhian.chat.usecase.InitChat;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/chats")
@RequiredArgsConstructor
public class ChatController {

    private final InitChat initChat;

    @PostMapping("/init")
    public ResponseEntity<InitChatResponse> initChat(@RequestBody @Valid InitChatRequest initChatRequest) {
        var chat = initChat.execute(initChatRequest);
        var initChatResponse = ChatMapper.INSTANCE.toInitChatResponse(chat);

        return ResponseEntity.ok(initChatResponse);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ChatResponse> chats() {
        return null;
    }
}
