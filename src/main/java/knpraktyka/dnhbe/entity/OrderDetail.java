package knpraktyka.dnhbe.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class OrderDetail {

      @Id
      @Column(name = "order_detail_id")
      private Integer id;

      @ManyToOne
      @JoinColumn(name = "order_id")
      private Order order;

      @Column(name = "tokens_amount")
      private Integer tokensAmount;

      private BigDecimal price;

      @ManyToOne
      @JoinColumn(name = "priceing_benchmark_id")
      private PricingBenchmark pricingBenchmark;

      // Gettery i settery
}

