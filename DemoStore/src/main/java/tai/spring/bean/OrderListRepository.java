package tai.spring.bean;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepository extends JpaRepository<OrderList, String> {

	public List<OrderList> findByUserNo(Integer userNo);
}
