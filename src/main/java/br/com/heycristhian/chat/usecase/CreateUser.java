package br.com.heycristhian.chat.usecase;

import br.com.heycristhian.chat.mapper.UserMapper;
import br.com.heycristhian.chat.model.User;
import br.com.heycristhian.chat.repository.UserRepository;
import br.com.heycristhian.chat.rest.dto.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUser {

    private final UserRepository userRepository;

    public User execute(UserRequest userRequest) {
        var user = UserMapper.INSTANCE.toUser(userRequest);

        return userRepository.save(user);
    }
}
