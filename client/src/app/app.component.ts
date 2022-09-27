import { Component, OnInit} from '@angular/core';
import { OrderService } from './services/order.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'client';

  constructor(private orderservice: OrderService){}

  ngOnInit(): void {
    this.orderservice.getOrders().subscribe(value => this.orderservice.changeNbrOrders(value.length));
  }
}
