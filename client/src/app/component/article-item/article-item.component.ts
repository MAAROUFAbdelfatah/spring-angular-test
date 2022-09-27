import { Component, OnInit, Input,  Output, EventEmitter} from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';


import { Article } from 'src/app/Models/Article';
@Component({
  selector: 'app-article-item',
  templateUrl: './article-item.component.html',
  styleUrls: ['./article-item.component.css']
})
export class ArticleItemComponent implements OnInit {
  @Input() article!: Article;
  @Output() addToCart: EventEmitter<Article> = new EventEmitter();
  image: any;
  
  
  constructor(private sanitizer: DomSanitizer) {
    
   }

  ngOnInit(): void {
    let objectURL = this.article!.picture;
    this.image = this.sanitizer.bypassSecurityTrustUrl(objectURL);
  }
  onAddToCart(article: Article){
    this.addToCart.emit(article);
  }
}
