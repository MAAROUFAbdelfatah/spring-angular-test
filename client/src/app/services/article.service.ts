import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Article } from '../Models/Article';

const httpOptions ={
  headers: new HttpHeaders(
    {'Content-Type': 'application/json'}
  )
} 

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  private urlApi = "http://localhost:8080/articles"
  constructor( private http: HttpClient) { }

  getArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(this.urlApi);
  }

  saveArticle(article: Article){
    return this.http.post<Article>(this.urlApi, article, httpOptions);
  }
}
