package knpraktyka.dnhbe.entity;

import jakarta.persistence.*;
import knpraktyka.dnhbe.ChatSession;

import java.time.LocalDateTime;

@Entity
public class Message {

      @Id
      @Column(name = "message_id")
      private int messageId;

      @ManyToOne
      @JoinColumn(name = "session_id")
      private ChatSession chatSession;

      @Column(name = "message_nr")
      private int messageNr;

      private String question;
      private String response;

      @Column(name = "sent_at")
      private LocalDateTime sentAt;

      @Column(name = "responded_at")
      private LocalDateTime respondedAt;

      // Gettery i Settery
}

