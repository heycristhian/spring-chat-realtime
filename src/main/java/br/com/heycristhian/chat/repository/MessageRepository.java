package br.com.heycristhian.chat.repository;

import br.com.heycristhian.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
