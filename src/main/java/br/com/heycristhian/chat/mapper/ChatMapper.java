package br.com.heycristhian.chat.mapper;

import br.com.heycristhian.chat.model.Chat;
import br.com.heycristhian.chat.rest.dto.response.InitChatResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChatMapper {

    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);

    InitChatResponse toInitChatResponse(Chat chat);
}
