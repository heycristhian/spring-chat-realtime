package br.com.heycristhian.chat.usecase;

import br.com.heycristhian.chat.model.Chat;
import br.com.heycristhian.chat.model.User;
import br.com.heycristhian.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateChat {

    private final ChatRepository chatRepository;

    public Chat execute(List<User> users) {
        var chat = generateChat(users);
        return chatRepository.save(chat);
    }

    private Chat generateChat(List<User> users) {
        return Chat.builder()
                .users(new HashSet<>(users))
                .build();
    }
}
