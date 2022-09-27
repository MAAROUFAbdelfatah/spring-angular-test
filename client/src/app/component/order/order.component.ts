
import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/Models/order';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  orders: Order[] = []
  constructor(private serviceOrder: OrderService) { 
    
  }
  ngOnInit(): void {
    this.serviceOrder.getOrders().subscribe(orders => {
      this.orders = orders;
    });
    
  }

  onEdit(order: Order){
    this.serviceOrder.setOrderToEdit(order);
  }
}
