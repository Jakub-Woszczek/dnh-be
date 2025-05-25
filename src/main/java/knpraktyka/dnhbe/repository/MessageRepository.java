package knpraktyka.dnhbe.repository;

import knpraktyka.dnhbe.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
