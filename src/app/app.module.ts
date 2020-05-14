import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {SpeechSynthesisModule, SpeechSynthesisUtteranceFactoryService} from '@kamiazya/ngx-speech-synthesis';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DomainListComponent } from './components/domain-list/domain-list.component';
import {Routes, RouterModule} from '@angular/router';
import { UpdateDomainComponent } from './components/update-domain/update-domain.component';
import { AddDomainComponent } from './components/add-domain/add-domain.component';
import {FormsModule} from '@angular/forms';
import { NewsComponent } from './components/news/news.component';
import { NewsDetailsComponent } from './components/news-details/news-details.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AuthGuardService } from './services/auth-guard.service';
import { BasicauthhttpinterceptorService } from './services/basicauthhttpinterceptor.service';


const routes: Routes = [
  {path : 'login' , component: LoginComponent},
  {path : 'logout' , component: LogoutComponent, canActivate:[AuthGuardService]},
  {path : 'domain/:id' , component: DomainListComponent, canActivate:[AuthGuardService]},
  {path : 'domains', component: DomainListComponent, canActivate:[AuthGuardService]},
  {path : 'add' , component: AddDomainComponent, canActivate:[AuthGuardService]},
  {path : 'update/:id' , component: UpdateDomainComponent, canActivate:[AuthGuardService]},
  {path : 'details/:id' , component: NewsDetailsComponent},
  {path : 'news', component: NewsComponent},
  {path : '' , redirectTo:'/news', pathMatch: 'full', canActivate:[AuthGuardService]},
  {path : '**' , redirectTo:'/news', pathMatch: 'full', canActivate:[AuthGuardService]}

];

@NgModule({
  declarations: [
    AppComponent,
    DomainListComponent,
    UpdateDomainComponent,
    AddDomainComponent,
    NewsComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'}),
    FormsModule,
    SpeechSynthesisModule.forRoot({
      lang: 'en',
      volume: 1.0,
      pitch: 1.0,
      rate: 1.0,
    }),
  ],
  providers:[
    {  
      provide:HTTP_INTERCEPTORS, useClass: BasicauthhttpinterceptorService, multi:true 
    },
    SpeechSynthesisUtteranceFactoryService
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
