package knpraktyka.dnhbe.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class PricingBenchmark {

      @Id
      @Column(name = "pricing_benchmark_id")
      private int pricingBenchmarkId;

      @Column(name = "min_quantity")
      private int minQuantity;

      @Column(name = "max_quantity")
      private int maxQuantity;

      @Column(name = "price_per_unit")
      private BigDecimal pricePerUnit;

      @OneToMany(mappedBy = "pricingBenchmark")
      private List<OrderDetail> orderDetails;

      // Gettery i Settery
}

