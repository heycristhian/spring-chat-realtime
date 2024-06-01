package br.com.heycristhian.chat.usecase;

import br.com.heycristhian.chat.model.Chat;
import br.com.heycristhian.chat.model.Message;
import br.com.heycristhian.chat.model.User;
import br.com.heycristhian.chat.repository.MessageRepository;
import br.com.heycristhian.chat.rest.dto.InitChatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMessage {

    private final MessageRepository messageRepository;

    public Message execute(User fromUser, InitChatRequest initChatRequest, Chat chat) {
        var message = generateMessage(initChatRequest, fromUser, chat);

        return messageRepository.save(message);
    }

    private static Message generateMessage(InitChatRequest initChatRequest, User fromUser, Chat chatSaved) {
        return Message.builder()
                .text(initChatRequest.getText())
                .fromUser(fromUser)
                .chat(chatSaved)
                .build();
    }
}
