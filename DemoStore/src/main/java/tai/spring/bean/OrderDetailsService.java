package tai.spring.bean;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
	
	@Autowired
	OrderDetailsRepository orderDetailsReop;
	
	public OrderDetails putOrderDetails(OrderDetails orderDetails) {
		return orderDetailsReop.save(orderDetails);
	}
	
	public OrderDetails findOrderDetailByOrderNo(String orderNo, Integer itemNo){
		OrderDetailsPrimarykey primaryKey = new OrderDetailsPrimarykey();
		primaryKey.setItemNo(itemNo);
		primaryKey.setOrderNo(orderNo);
		Optional<OrderDetails> result = orderDetailsReop.findById(primaryKey);
		return result.get();
	}
}
