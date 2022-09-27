import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/Models/Article';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit {
  uploadedImage!: any;
  articleForm!: FormGroup
  imageSize!: number;
  maxSize: number = 4;

  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.articleForm = new FormGroup({
      name: new FormControl(null, Validators.required),
      price: new FormControl(null, Validators.required),
      picture: new FormControl(null, Validators.required,)
    })
  }

  public onImageUpload(event: any){
    this.imageSize = event.target.files[0].size/1024/1024
    const reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = () => {
      this.uploadedImage = reader.result;
    };
  }

  addArticle(){
    if(this.imageSize > this.maxSize)
      alert("ckeck the size of the image, must be: < 4 MB !")
      const newArticle: Article =
      {
        id: 0,
        name: this.articleForm.get('name')?.value,
        price: this.articleForm.get('price')?.value,
        picture: this.uploadedImage,
      };
      console.log(newArticle);
      this.articleService.saveArticle(newArticle).subscribe();
      this.articleForm.reset()
    }

}
