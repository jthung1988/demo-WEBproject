package tai.spring.bean;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsPrimarykey> {
}
