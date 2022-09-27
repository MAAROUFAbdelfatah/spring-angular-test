package lu.atozdigital.api.order;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lu.atozdigital.api.exception.ApiRestException;

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
	
	@PutMapping(path = "{orderId}")
	public ResponseEntity<Object> editOrder(@PathVariable("orderId") Long id
			,@Valid @RequestBody OrderDTO orderDTORequest){
		Order orderRequest;
		Optional<Order> orderO;
		Order order;

		orderRequest = modelMapper.map(orderDTORequest, Order.class);		
		orderO = orderService.getOrder(id);
		if (!orderO.isPresent())
			throw new ApiRestException("Oops order not found !!"); 
		order = orderO.get();
		order.setArticles(orderRequest.getArticles());
		orderService.saveOrder(order);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
