package br.com.heycristhian.chat.validate.impl;

import br.com.heycristhian.chat.model.User;
import br.com.heycristhian.chat.repository.ChatRepository;
import br.com.heycristhian.chat.validate.UsersInitChatValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NonExistsChatByUsers implements UsersInitChatValidate {

    private final ChatRepository chatRepository;

    @Override
    public void execute(List<User> users) {
        //TODO implementar
    }
}
