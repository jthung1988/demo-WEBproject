package tai.spring.bean;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderListService {

	@Autowired
	OrderListRepository orderlistRepo;
	
	public OrderList putOrderList(OrderList orderList) {
		OrderList result = orderlistRepo.save(orderList);
		return result;
	}
	
	public List<OrderList> getOrderListByUserNo(Integer userNo){
		List<OrderList> result = orderlistRepo.findByUserNo(userNo);
		return result;
	}
	
	public OrderList getOrderListByOrderNo(String orderNo) {
		Optional<OrderList> resultList = orderlistRepo.findById(orderNo);
		OrderList result = resultList.get();
		return result;
	}
	
}
