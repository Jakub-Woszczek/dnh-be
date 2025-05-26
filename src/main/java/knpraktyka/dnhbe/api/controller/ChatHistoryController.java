package knpraktyka.dnhbe.api.controller;

import knpraktyka.dnhbe.entity.ChatHistory;
import knpraktyka.dnhbe.api.service.ChatHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat-history")
public class ChatHistoryController {

    private final ChatHistoryService chatHistoryService;

    public ChatHistoryController(ChatHistoryService chatHistoryService) {
        this.chatHistoryService = chatHistoryService;
    }

    @GetMapping("/user/{userId}")
    public List<ChatHistory> getChatHistoryByUserId(@PathVariable Integer userId) {
        return chatHistoryService.getChatHistoryByUserId(userId);
    }
}