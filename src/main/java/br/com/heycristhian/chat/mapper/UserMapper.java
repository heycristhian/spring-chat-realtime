package br.com.heycristhian.chat.mapper;


import br.com.heycristhian.chat.model.User;
import br.com.heycristhian.chat.rest.dto.request.UserRequest;
import br.com.heycristhian.chat.rest.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);
}
