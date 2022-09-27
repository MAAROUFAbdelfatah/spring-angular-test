import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable,Subject } from 'rxjs';
import { Article } from '../Models/Article';
import { Order } from '../Models/order';

const httpOptions ={
  headers: new HttpHeaders(
    {'Content-Type': 'application/json'}
  )
} 

@Injectable({
  providedIn: 'root'
})

export class OrderService {
  nbrOrdersSubject = new Subject<any>();
  nbrOrders!: number;
  private urlApi = "http://localhost:8080/orders";
  orderEdit!: Order;
  constructor(private httpOrder: HttpClient) { }

  getOrders(): Observable<Order[]> {
    return this.httpOrder.get<Order[]>(this.urlApi);
  }

  changeNbrOrders(orderaNbr: number){
    this.nbrOrders = orderaNbr;
    this.nbrOrdersSubject.next(this.nbrOrders);
  }

  onChangeNbrOrders(): Observable<any> {
    return this.nbrOrdersSubject.asObservable();
  }

  saveOrder(articles: Article[]){
    this.changeNbrOrders(this.nbrOrders + 1);
    const order = {
      articles : articles,
    }
    return this.httpOrder.post<Order>(this.urlApi, order, httpOptions);
  }

  getOrderToEdit(){
    return this.orderEdit;
  }

  setOrderToEdit(order: Order){
    this.orderEdit = order
  }

  updateOrder(order: Order){
    const url  = `${this.urlApi}/${order.id}`;
    return this.httpOrder.put<Order>(url, order, httpOptions);
  }
}
