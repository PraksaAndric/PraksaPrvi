import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { News } from '../common/news';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  private baseUrl= 'http://localhost:8080/news';
  
 

  constructor(private httpClient: HttpClient) { }

  getNews(link:string):Observable<News>{
    const params = new HttpParams().set('url', link);
    return this.httpClient.get<News>(`${this.baseUrl}/details`, {params});
  }

  getNewsById(id:number):Observable<News>{
    return this.httpClient.get<News>(`${this.baseUrl}/name/${id}`);
  }

  getAudio(id:number){
    return this.httpClient.get(`${this.baseUrl}/audio/${id}`);
  }
}
