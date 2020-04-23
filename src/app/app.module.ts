import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DomainListComponent } from './components/domain-list/domain-list.component';
import { DomainService } from './services/domain.service';
import {Routes, RouterModule} from '@angular/router';
import { UpdateDomainComponent } from './components/update-domain/update-domain.component';
import { AddDomainComponent } from './components/add-domain/add-domain.component';
import {FormsModule} from '@angular/forms';
import { NewsComponent } from './components/news/news.component';
import { NewsDetailsComponent } from './components/news-details/news-details.component';


const routes: Routes = [
  {path : 'domain/:id' , component: DomainListComponent},
  {path : 'domains', component: DomainListComponent},
  {path : 'add' , component: AddDomainComponent},
  {path : 'update/:id' , component: UpdateDomainComponent},
  {path : 'details/:id' , component: NewsDetailsComponent},
  {path : 'news', component: NewsComponent},
  {path : '' , redirectTo:'/domains', pathMatch: 'full'},
  {path : '**' , redirectTo:'/domains', pathMatch: 'full'}

];

@NgModule({
  declarations: [
    AppComponent,
    DomainListComponent,
    UpdateDomainComponent,
    AddDomainComponent,
    NewsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'}),
    FormsModule
  ],
  providers: [DomainService],
  bootstrap: [AppComponent]
})
export class AppModule { }
