package br.com.heycristhian.chat.validate;

import br.com.heycristhian.chat.model.User;

import java.util.List;

public interface UsersInitChatValidate {

    void execute(List<User> users);
}
