import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { Article } from 'src/app/Models/Article';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.css']
})
export class CartItemComponent implements OnInit {
  faTrash = faTrashAlt;
  @Output() deleteArticle: EventEmitter<Article> = new EventEmitter();
  @Input() article!: Article;
  image: any;

  constructor(private sanitizer: DomSanitizer) {}

  ngOnInit(): void {
    let objectURL = this.article!.picture;
    this.image = this.sanitizer.bypassSecurityTrustUrl(objectURL);
  }

  onDelete(article: Article){
    this.deleteArticle.emit(article);
  }

}
