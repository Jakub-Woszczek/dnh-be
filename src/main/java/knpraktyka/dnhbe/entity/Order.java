package knpraktyka.dnhbe.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "\"order\"")
public class Order {

      @Id
      @Column(name = "order_id")
      private int orderId;

      @ManyToOne
      @JoinColumn(name = "user_id")
      private User user;

      @Column(name = "order_date")
      private LocalDate orderDate;

      @OneToMany(mappedBy = "order")
      private List<OrderDetail> orderDetails;

      // Gettery i Settery
}


