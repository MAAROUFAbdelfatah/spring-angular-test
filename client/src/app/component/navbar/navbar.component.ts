import { Component, OnInit, SimpleChanges } from '@angular/core';
import { faCartShopping } from '@fortawesome/free-solid-svg-icons';
import { CartService } from 'src/app/services/cart.service';
import { Subscription } from 'rxjs';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  articlesSubscription!: Subscription;
  ordersSubscription!: Subscription;
  nbrArticles: number = 0;
  nbrOrders: number = 0;
  faCart = faCartShopping;

  constructor(private cartService: CartService, private orderService: OrderService) { 
    this.ordersSubscription = this.cartService
      .onChangeNbrArticle().subscribe(value => this.nbrArticles = value);
    this.ordersSubscription = this.orderService
    .onChangeNbrOrders().subscribe(vaule => this.nbrOrders = vaule);
  }

  ngOnInit(): void {
    this.nbrArticles = this.cartService.nbrArticles;
  }
}
