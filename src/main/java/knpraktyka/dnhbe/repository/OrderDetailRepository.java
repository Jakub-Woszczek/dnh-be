package knpraktyka.dnhbe.repository;

import knpraktyka.dnhbe.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
