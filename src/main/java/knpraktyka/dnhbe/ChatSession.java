package knpraktyka.dnhbe;

import jakarta.persistence.*;
import knpraktyka.dnhbe.entity.Message;
import knpraktyka.dnhbe.entity.User;

import java.time.LocalDate;
import java.util.List;

@Entity
public class ChatSession {

      @Id
      @Column(name = "session_id")
      private int sessionId;

      @ManyToOne
      @JoinColumn(name = "user_id")
      private User user;

      @Column(name = "started_at")
      private LocalDate startedAt;

      @OneToMany(mappedBy = "chatSession")
      private List<Message> messages;

      // Gettery i Settery
}

