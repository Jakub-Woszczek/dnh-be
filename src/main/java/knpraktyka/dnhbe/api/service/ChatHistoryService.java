package knpraktyka.dnhbe.api.service;

import knpraktyka.dnhbe.entity.ChatHistory;
import knpraktyka.dnhbe.repository.ChatHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatHistoryService {

    private final ChatHistoryRepository chatHistoryRepository;

    public ChatHistoryService(ChatHistoryRepository chatHistoryRepository) {
        this.chatHistoryRepository = chatHistoryRepository;
    }

    public List<ChatHistory> getChatHistoryByUserId(Integer userId) {
        return chatHistoryRepository.findByUser_Id(userId);
    }
}