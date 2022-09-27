package lu.atozdigital.api.order;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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
	
	public void addOrder(Order order) {
		int ref_buffer;
		
		ref_buffer = 10;
		order.setReference(refGenerator(ref_buffer));
		order.setDate(dateGenerater());
		orderRepository.save(order);
	}
	
	private String dateGenerater() {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("EEEE dd MMMM yyyy hh:mm:s");
		return simpleformat.format(cal.getTime());
	}
	private String refGenerator(int n){
		String base;
		int index;
		StringBuilder ref;
		
		base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";
		ref = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			index = (int)(base.length() * Math.random());
			ref.append(base.charAt(index));
		}
		return ref.toString();
	}
	
	public Optional<Order> getOrder(Long id) {
		return orderRepository.findById(id);
	}
	
	public void saveOrder(Order order) {
		orderRepository.save(order);
	}

}
