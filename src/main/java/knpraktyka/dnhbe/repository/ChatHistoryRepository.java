package knpraktyka.dnhbe.repository;

import knpraktyka.dnhbe.entity.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Integer> {
}
