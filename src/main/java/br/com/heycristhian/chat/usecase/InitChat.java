package br.com.heycristhian.chat.usecase;

import br.com.heycristhian.chat.exception.InternalErrorException;
import br.com.heycristhian.chat.model.Chat;
import br.com.heycristhian.chat.model.Message;
import br.com.heycristhian.chat.repository.ChatRepository;
import br.com.heycristhian.chat.rest.dto.InitChatRequest;
import br.com.heycristhian.chat.validate.UsersInitChatValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InitChat {

    private final ChatRepository chatRepository;
    private final FindUser findUser;
    private final CreateMessage createMessage;
    private final List<UsersInitChatValidate> usersValidate;

    public Chat execute(InitChatRequest initChatRequest) {
        //TODO resolver logica
        var users = findUser.allById(initChatRequest.getUsersId());
        usersValidate.forEach(validate -> validate.execute(users));

        var chat = Chat.builder()
                .users(new HashSet<>(users))
                .build();

        var chatSaved = chatRepository.save(chat);

        var fromUser = users
                .stream()
                .filter(user -> initChatRequest.getFromUserId().equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new InternalErrorException("User not found"));

        var message = Message.builder()
                .text(initChatRequest.getText())
                .fromUser(fromUser)
                .chat(chatSaved)
                .build();

        var messageSaved = createMessage.execute(message);

        chatSaved.addMessage(messageSaved);

        return chatRepository.save(chatSaved);
    }

}
