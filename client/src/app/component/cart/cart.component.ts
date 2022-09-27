import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/Models/Article';
import { CartService } from 'src/app/services/cart.service';
import { OrderService } from 'src/app/services/order.service';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],

})
export class CartComponent implements OnInit {
  subscription!: Subscription;
  cart: Article[] = [];
  totalAmount: number = 0;
 
  constructor(private cartService:CartService, private orderService: OrderService) { 
    this.subscription = this.cartService.onChangeTotalAmount()
    .subscribe(amount => this.totalAmount=amount);
  }

  ngOnInit(): void {
    this.cart = this.cartService.getCart();
  }

  onDeleteArticle(article: Article){
    this.cartService.deleteArticle(article);
    this.cart = this.cartService.getCart();
  }

  onAddToOrders(cart: Article[]){
    this.orderService.saveOrder(cart).subscribe((res) => console.log(res));
    this.cart = [];
    this.cartService.freeCart();
    this.cartService.changeNbrArticles();
  }

}
