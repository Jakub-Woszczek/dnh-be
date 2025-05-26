package knpraktyka.dnhbe.repository;

import knpraktyka.dnhbe.entity.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Integer> {
    List<ChatHistory> findByUser_Id(Integer userId);
}
