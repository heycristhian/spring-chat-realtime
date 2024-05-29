package br.com.heycristhian.chat.rest.controller;

import br.com.heycristhian.chat.mapper.UserMapper;
import br.com.heycristhian.chat.rest.dto.request.UserRequest;
import br.com.heycristhian.chat.rest.dto.response.UserResponse;
import br.com.heycristhian.chat.usecase.CreateUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUser createUser;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        var user = createUser.execute(userRequest);
        var userResponse = UserMapper.INSTANCE.toUserResponse(user);

        URI uri = uriBuilder.path("/v1/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(userResponse);
    }
}
