package br.com.heycristhian.chat.usecase;

import br.com.heycristhian.chat.exception.ObjectNotFoundException;
import br.com.heycristhian.chat.model.User;
import br.com.heycristhian.chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindUser {

    private final UserRepository userRepository;

    public User byId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public List<User> allById(List<Long> usersId) {
        return userRepository.findAllById(usersId);
    }
}
