import { Component, OnInit} from '@angular/core';
import { ArticleService } from 'src/app/services/article.service';
import { Article } from 'src/app/Models/Article';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css'],

})
export class ArticlesComponent implements OnInit {
  articles: Article[] = [];

  constructor(private articleService: ArticleService, private cartService: CartService) { 
  }

  ngOnInit(): void {
    this.articleService.getArticles().subscribe(articles => this.articles = articles);
  }

  onAddToCart(article: Article){
    this.cartService.onAddToCart(article);
  }

}
