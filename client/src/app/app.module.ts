import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { ArticlesComponent } from './component/articles/articles.component';
import { ArticleItemComponent } from './component/article-item/article-item.component';
import { AddArticleComponent } from './component/add-article/add-article.component';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CartComponent } from './component/cart/cart.component';
import { CartItemComponent } from './component/cart-item/cart-item.component';
import { OrderComponent } from './component/order/order.component';
import { EditOrderComponent } from './component/edit-order/edit-order.component'

const appRouters: Routes = [
  { path: "", component:ArticlesComponent },
  { path: "AddArticle", component:AddArticleComponent },
  {path: "Cart", component:CartComponent},
  {path: "Orders", component:OrderComponent},
  {path: "EditOrder", component:EditOrderComponent}

]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ArticlesComponent,
    ArticleItemComponent,
    AddArticleComponent,
    CartComponent,
    CartItemComponent,
    OrderComponent,
    EditOrderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRouters, {enableTracing: true}),
    FontAwesomeModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
