package br.com.heycristhian.chat.validate.impl;

import br.com.heycristhian.chat.exception.ValidateException;
import br.com.heycristhian.chat.model.User;
import br.com.heycristhian.chat.validate.UsersInitChatValidate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MinimumTwoUsersValidate implements UsersInitChatValidate {

    @Override
    public void execute(List<User> users) {
        if (users.size() < 2) {
            throw new ValidateException("Not enough users were found");
        }
    }
}
