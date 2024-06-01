package br.com.heycristhian.chat.usecase;

import br.com.heycristhian.chat.exception.InternalErrorException;
import br.com.heycristhian.chat.model.Chat;
import br.com.heycristhian.chat.model.User;
import br.com.heycristhian.chat.repository.ChatRepository;
import br.com.heycristhian.chat.rest.dto.InitChatRequest;
import br.com.heycristhian.chat.validate.UsersInitChatValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitChat {

    private final ChatRepository chatRepository;
    private final FindUser findUser;
    private final CreateMessage createMessage;
    private final CreateChat createChat;
    private final List<UsersInitChatValidate> usersValidate;

    public Chat execute(InitChatRequest initChatRequest) {
        var users = findUser.allById(initChatRequest.getUsersId());

        usersValidate.forEach(validate -> validate.execute(users));

        var chatSaved = createChat.execute(users);
        var fromUser = findUserById(users, initChatRequest);

        var messageSaved = createMessage.execute(fromUser, initChatRequest, chatSaved);
        chatSaved.addMessage(messageSaved);

        return chatRepository.save(chatSaved);
    }

    private User findUserById(List<User> users, InitChatRequest initChatRequest) {
        return users
                .stream()
                .filter(user -> initChatRequest.getFromUserId().equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new InternalErrorException("User not found"));
    }
}
