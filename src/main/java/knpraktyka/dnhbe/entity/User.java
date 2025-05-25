package knpraktyka.dnhbe.entity;

import knpraktyka.dnhbe.ChatSession;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

      @Id
      @Column(name = "user_id")
      private Integer id;

      private String email;
      private String nick;
      private String name;

      @Column(name = "second_name")
      private String secondName;

      @Column(name = "registration_date")
      private LocalDateTime registrationDate;

      @OneToMany(mappedBy = "user")
      private List<ChatSession> chatSessions;

      @OneToMany(mappedBy = "user")
      private List<ChatHistory> chatHistories;

      @OneToMany(mappedBy = "user")
      private List<Order> orders;

      // Gettery i settery
}

