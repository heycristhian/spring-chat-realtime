package br.com.heycristhian.chat.controller;

import br.com.heycristhian.chat.model.Message;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/messages")
@RequiredArgsConstructor
public class MessageController {

//    @PostMapping
//    public ResponseEntity<Void> sendMessage(@RequestBody @Valid Message message) {
//
//    }
}
