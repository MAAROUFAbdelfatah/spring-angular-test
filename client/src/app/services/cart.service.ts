
import { Injectable} from '@angular/core';
import { Article } from '../Models/Article';
import { Observable, Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CartService {
  private nbrArticlesSubject = new Subject<any>();
  private totalAmountSubject = new Subject<any>();
  card: Article[] = [];
  totalAmount: number = 0;
  nbrArticles: number = 0;

  constructor() { }

  onChangeTotalAmount(): Observable<any>{
    return this.totalAmountSubject.asObservable();
  }

  changeTotalAmount(){
    this.totalAmount = 0;
    this.card.map(article => {this.totalAmount +=  article.price});
    this.totalAmountSubject.next(this.totalAmount);
  }

  onChangeNbrArticle(): Observable<any>{
    return this.nbrArticlesSubject.asObservable();
  }
  
  changeNbrArticles(){
    this.nbrArticles = this.card.length;
    this.nbrArticlesSubject.next(this.nbrArticles);
  }

  onAddToCart(article: Article){
    this.card.push(article);
    this.changeNbrArticles();
    this.changeTotalAmount()
  }
  

  getCart(): Article[]{
    this.changeTotalAmount();
    return this.card;
  }

  deleteArticle(article: Article){
    this.card = this.card.filter(obj => {return obj !== article});
    this.changeNbrArticles();
    this.changeTotalAmount();

  }

  freeCart(){
    this.card = [];
  }
}
