package lu.atozdigital.api.order;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/orders")
public class OrderController {

	@Autowired
	private ModelMapper modelMapper;
	final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@GetMapping()
	public List<OrderDTO> getOrders(){
		List<OrderDTO> ordersDTO;
		List<Order> orders;
		orders = orderService.getOrders();
		ordersDTO = orders.stream().map(order -> modelMapper.map(order, OrderDTO.class))
				.collect(Collectors.toList());
		return ordersDTO;
	}
	
	@PostMapping
	public void addOrder(@RequestBody OrderDTO orderDTO){
		Order order;
		order = modelMapper.map(orderDTO, Order.class);
		orderService.addOrder(order);
	}
}
