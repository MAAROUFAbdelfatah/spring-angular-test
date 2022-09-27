package lu.atozdigital.api.order;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
final IOrderRepository orderRepository;
	
	@Autowired
	public OrderService(IOrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

}
