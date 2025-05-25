package knpraktyka.dnhbe.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ChatHistory {

      @Id
      @Column(name = "session_id")
      private int sessionId;

      @ManyToOne
      @JoinColumn(name = "user_id")
      private User user;

      private LocalDate date;

      @Column(name = "message_id")
      private int messageId;

      private String question;
      private String response;

      @Column(name = "sent_at")
      private LocalDateTime sentAt;

      @Column(name = "responded_at")
      private LocalDateTime respondedAt;

      @Column(name = "session_name")
      private String sessionName;

      // Gettery i Settery
}
