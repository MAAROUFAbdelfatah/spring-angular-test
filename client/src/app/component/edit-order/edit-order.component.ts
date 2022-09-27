import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/Models/Article';
import { Order } from 'src/app/Models/order';
import { ArticleService } from 'src/app/services/article.service';
import { OrderService } from 'src/app/services/order.service';
import { faAngleDown } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-edit-order',
  templateUrl: './edit-order.component.html',
  styleUrls: ['./edit-order.component.css']
})
export class EditOrderComponent implements OnInit {
  order!: Order;
  articles: Article[] = [];
  downArrow = faAngleDown;
  constructor(private orderService: OrderService, private articleService: ArticleService) { }

  ngOnInit(): void {
    this.order = this.orderService.getOrderToEdit();
    this.articleService.getArticles().subscribe(articles => this.articles = articles)
  }

  addArticleToOrder(article: Article){
    this.order.articles.push(article);
  }

  onDeleteArticleOrder(article: Article){
    this.order.articles = this.order.articles.filter(obj => {return obj !== article});
  }
  editOrder(){
    this.orderService.updateOrder(this.order).subscribe(res => console.log(res));
  }
}
