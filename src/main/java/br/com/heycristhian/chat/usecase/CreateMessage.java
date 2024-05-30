package br.com.heycristhian.chat.usecase;

import br.com.heycristhian.chat.model.Message;
import br.com.heycristhian.chat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMessage {

    private final MessageRepository messageRepository;

    public Message execute(Message message) {
        return messageRepository.save(message);
    }
}
